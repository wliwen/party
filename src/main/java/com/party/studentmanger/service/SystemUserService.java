package com.party.studentmanger.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.entity.SystemUsersEntity;
import com.party.studentmanger.mapper.SystemUsersMapper;
import com.party.studentmanger.utils.RedisUtils;
import com.party.studentmanger.utils.TokenUtils;

@Service
public class SystemUserService {
	@Autowired
	private TokenUtils util;
	@Autowired
	RedisUtils rutils;
	
	private SystemUsersEntity entity=new SystemUsersEntity();
	@Autowired
	SystemUsersMapper mapper;
	public HashMap<String, Object> loginSystem(HashMap<String, String> map) {
		
		HashMap<String, Object>  result=new HashMap<String, Object>();
		
		//验证
		entity=mapper.loginSystem(map);
		if(entity==null) {
			result.put("msg", "用户不存在！");
			
			return result;
		}else if(!entity.getUser_password().equals(map.get("user_password"))) {
			result.put("msg", "密码错误！");
			return result;
		}else {
			String token =util.getToken(entity);
			String key=entity.getUser_name()+entity.getUser_password();
			rutils.set(key, token,7200);
			//将生成token存入redis
			result.put("token", token);
			result.put("user",entity);
		}
		return result;
	}

	public SystemUsersEntity getUserByID(String userid) {
		return mapper.getUserByID(userid);
	}
	
	public HashMap<String, Object> updateSystem(HashMap<String, String> map) {
		
		return null;
	}
}
