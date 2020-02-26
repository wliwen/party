package com.party.studentmanger.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.elementtype.PassToken;
import com.party.studentmanger.entity.SystemUsersEntity;
import com.party.studentmanger.service.SystemUserService;
import com.party.studentmanger.utils.RedisUtils;
/**
 * token拦截器 ，用于请求token解密，以及token验证
 * */
public class TokenFilterHandle implements HandlerInterceptor {
	 @Autowired
	 SystemUserService userService;
	 @Autowired
	 RedisUtils utils;
	    @Override
	    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
	    	String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
	        // 如果不是映射到方法直接通过
	        if(!(object instanceof HandlerMethod)){
	            return true;
	        }
	        HandlerMethod handlerMethod=(HandlerMethod)object;
	        Method method=handlerMethod.getMethod();
	        //检查是否有passtoken注释，有则跳过认证
	        if (method.isAnnotationPresent(PassToken.class)) {
	            PassToken passToken = method.getAnnotation(PassToken.class);
	            if (passToken.required()) {
	                return true;
	            }
	        }
	        //检查有没有需要用户权限的注解
	        if (method.isAnnotationPresent(MustToken.class)) {
	        	MustToken mustToken = method.getAnnotation(MustToken.class);
	            if (mustToken.required()) {
	                // 执行认证
	                if (token == null) {
	                    throw new RuntimeException("无token，请登录");
	                }
	                // 获取 token 中的 user id
	                String userId;
	                try {
	                    userId = JWT.decode(token).getAudience().get(0);
	                } catch (JWTDecodeException j) {
	                    throw new RuntimeException("401");
	                }
	                SystemUsersEntity user = userService.getUserByID(userId);
	                if (user == null) {
	                    throw new RuntimeException("用户不存在，请重新登录");
	                }
	                // 解密验证token是否合法
	                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUser_id()+user.getUser_password())).build();
	                try {
	                    jwtVerifier.verify(token);
	                    System.out.println("token合法"); 
	                } catch (JWTVerificationException e) {
	                    throw new RuntimeException("401");
	                }
	                //验证token是否过期
	                if(utils.get(user.getUser_id()+user.getUser_password())!=null) {
	                	System.out.println("未过期");
	                }else {
	                	throw new RuntimeException("已过期或非法token");
	                
	                }
	                return true;
	            }
	        }
	        return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest httpServletRequest, 
	                                  HttpServletResponse httpServletResponse, 
	                            Object o, ModelAndView modelAndView) throws Exception {

	    }
	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, 
	                                          HttpServletResponse httpServletResponse, 
	                                          Object o, Exception e) throws Exception {
	    }
	
}
