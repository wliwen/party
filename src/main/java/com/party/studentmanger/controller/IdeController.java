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
import com.party.studentmanger.service.ActivityService;
import com.party.studentmanger.service.IdeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "思想管理接口")
@RestController
@RequestMapping("/party")
public class IdeController {
	@Autowired
	private IdeService service;
	
	
	@ApiOperation(value = "思想管理列表拉取", notes = "思想管理列表拉取")
	@RequestMapping(value = "/getilist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> getUserList(@RequestBody HashMap<String,Object> map) {
		return service.getTeacherList(map);
	}
	@ApiOperation(value = "思想管理新增", notes = "思想管理新增")
	@RequestMapping(value = "/addilist", method = RequestMethod.POST)
	@MustToken
	public Boolean addTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.addTeacherList(map);
	}
	
	@ApiOperation(value = "思想管理修改", notes = "思想管理修改")
	@RequestMapping(value = "/updteilist", method = RequestMethod.POST)
	@MustToken
	public Boolean updateTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.updateTeacherList(map);
	}
	
	@ApiOperation(value = "思想管理删除", notes = "思想管理删除")
	@RequestMapping(value = "/delilist", method = RequestMethod.POST)
	@MustToken
	public Boolean delTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.delTeacherList(map);
	}
}
