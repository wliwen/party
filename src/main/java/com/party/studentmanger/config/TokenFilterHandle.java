package com.party.studentmanger.config;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.elementtype.PassToken;
import com.party.studentmanger.entity.ResponseResult;
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
	                	printJson(httpServletResponse, "",new ResponseResult(4396,false,"token不存在,请重新登陆",null));
	                    return false;
	                }
	                // 获取 token 中的 user id
	                String userId;
	                try {
	                    userId = JWT.decode(token).getAudience().get(0);
	                } catch (JWTDecodeException j) {
	                	printJson(httpServletResponse, "",new ResponseResult(4396,false,"token解析异常,请重新登陆",null));
	                    return false;
	                }
	                SystemUsersEntity user = userService.getUserByID(userId);
	                if (user == null) {
	                	printJson(httpServletResponse, "",new ResponseResult(4396,false,"用户不存在",null));
	                }
	                // 解密验证token是否合法
	                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUser_id()+user.getUser_password())).build();
	                try {
	                    jwtVerifier.verify(token);
	                    System.out.println("token合法"); 
	                } catch (JWTVerificationException e) {
	                	printJson(httpServletResponse, "",new ResponseResult(4399,false,"不合法token",null));
	                    return false;
	                    
	                }
	                //验证token是否过期
	                if(utils.get(user.getUser_id()+user.getUser_password())!=null) {
	                	System.out.println("未过期");
	                }else {
	                	printJson(httpServletResponse, "",new ResponseResult(4396,false,"toekn过期 ,当前会话结束!",null));
	                	return false;
	                
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
	    //拦截完成后增加若干请求头
	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, 
	                                          HttpServletResponse httpServletResponse, 
	                                          Object o, Exception e) throws Exception {
	    	httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
	    	httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With, token");
	    	httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, HEAD, OPTIONS, POST, PUT, DELETE");
	    	httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
	    	httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
	    }
	    //token异常处理，自定义错误信息
	    @SuppressWarnings("unused")
		private static void printJson(HttpServletResponse response, String code,ResponseResult responseResult) {
	        String content = JSON.toJSONString(responseResult);
	        printContent(response, content);
	    }

	    //报文添加
	    private static void printContent(HttpServletResponse response, String content) {
	        try {
	            response.reset();
	            response.setContentType("application/json");
	            response.setHeader("Cache-Control", "no-store");
	            response.setCharacterEncoding("UTF-8");
	            PrintWriter pw = response.getWriter();
	            pw.write(content);
	            pw.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
