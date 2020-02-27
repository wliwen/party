package com.party.studentmanger.controller;

import java.util.HashMap;
import java.util.List;

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
@RequestMapping("/party")
public class SystemUsersController {
	@Autowired
	private SystemUserService service;
	@ApiOperation(value = "用户登录", notes = "用户登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String,Object> loginSystem(@RequestBody HashMap<String,String> map) {
		return service.loginSystem(map);
	}
	
	
	@ApiOperation(value = "拉取菜单", notes = "拉取菜单")
	@RequestMapping(value = "/getmenu", method = RequestMethod.POST)
	public List<HashMap<String,Object>> getMenu(@RequestBody HashMap<String,String> map) {
		return service.getMenu(map);
	}
	
}
