package com.party.studentmanger.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.utils.RedisUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Redis接口")
@RestController
@RequestMapping("/redis")
public class RedisTestController {
	@Autowired
	private RedisUtils util;
	@ApiOperation(value = "Redis接口存", notes = "Redis接口存")
	@RequestMapping(value = "/setKV", method = RequestMethod.POST)
	public boolean setKV(@RequestBody HashMap<String,Object> param){
		
		return util.set("key_01", param, 120);
	}
	
	@ApiOperation(value = "Redis接口取", notes = "Redis接口取")
	@RequestMapping(value = "/getKV", method = RequestMethod.GET)
	public Object getKV(){
		
		return util.get("key_01");
	}
}
