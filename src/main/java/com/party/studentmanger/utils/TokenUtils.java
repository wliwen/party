package com.party.studentmanger.utils;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.party.studentmanger.entity.SystemUsersEntity;

@Component
public class TokenUtils {
	//提供token生成方法
		
		public String getToken(SystemUsersEntity user) {
			String token="";
			token=JWT.create().withAudience(user.getID()).sign(Algorithm.HMAC256(user.getUserName()+user.getUserPassword()));
			return token;
		}
}
