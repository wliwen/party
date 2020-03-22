package com.party.studentmanger.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.service.UserMangerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "角色管理接口")
@RestController
@RequestMapping("/party")
public class UserMangerController {
	@Autowired
	private UserMangerService service;
	
	
	@ApiOperation(value = "角色管理列表拉取", notes = "角色管理列表拉取")
	@RequestMapping(value = "/getuserlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> getUserList(@RequestBody HashMap<String,Object> map) {
		return service.getUserList(map);
	}
	@ApiOperation(value = "解除角色登录权限", notes = "解除角色登录权限")
	@RequestMapping(value = "/fireuser", method = RequestMethod.GET)
	@MustToken
	public Boolean fireUser(@RequestParam(value ="user_id", required = false) String ID) {
		return service.fireUser(ID);
	}
	
}
