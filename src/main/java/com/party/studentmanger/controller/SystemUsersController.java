package com.party.studentmanger.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.service.SystemUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户接口")
@RestController
@RequestMapping("/users")
public class SystemUsersController {
	@Autowired
	private SystemUserService service;
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String,Object> loginSystem(@RequestBody HashMap<String,String> map) {
		return service.loginSystem(map);
	}
	
	@ApiOperation(value = "修改密码", notes = "修改密码")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@MustToken
	public HashMap<String,Object> updateSystem(@RequestBody HashMap<String,String> map) {
		return service.updateSystem(map);
	}
	
}
