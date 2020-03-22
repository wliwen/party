package com.party.studentmanger.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.service.HomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "主页接口")
@RestController
@RequestMapping("/party")
public class HomeController {
	@Autowired
	private HomeService service;
	@ApiOperation(value = "最近添加角色", notes = "最近添加角色")
	@RequestMapping(value = "/getnearuser", method = RequestMethod.GET)
	@MustToken
	public List<HashMap<String,Object>> getNearUser() {
		return service.getNearUser();
	}
	
}
