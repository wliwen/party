package com.party.studentmanger.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.entity.SystemUsersEntity;
import com.party.studentmanger.utils.RedisUtils;
import com.party.studentmanger.utils.TokenUtils;

@Service
public class SystemUserService {
	@Autowired
	private TokenUtils util;
	@Autowired
	RedisUtils rutils;
	public SystemUsersEntity  getUserByID(String userID) {
		return new SystemUsersEntity("123456", "李四", "123456789", "123");
	}
	
	public SystemUsersEntity  getUserByName(String userName) {
		return new SystemUsersEntity("123456", "李四", "123456789", "123");
	}

	public HashMap<String, Object> loginSystem(HashMap<String, String> map) {
		HashMap<String, Object>  result=new HashMap<String, Object>();
		int index=0;
		//验证
		SystemUsersEntity user=this.getUserByName(map.get("userName"));
		if(user==null) {
			result.put("msg"+index, "用户不存在！");
			index++;
		}else if(!user.getUserPassword().equals(map.get("userPassword"))) {
			result.put("msg"+index, "密码错误！");
			index++;
		}else {
			String token =util.getToken(user);
			String key=user.getUserName()+user.getUserPassword();
			rutils.set(key, token,7200);
			//将生成token存入redis
			result.put("token", token);
			result.put("user",user);
		}
		return result;
	}

	public HashMap<String, Object> updateSystem(HashMap<String, String> map) {
		
		return null;
	}
}
