package com.party.studentmanger.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.service.TeacherMangerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "老师管理接口")
@RestController
@RequestMapping("/party")
public class TeacherMangerController {
	@Autowired
	private TeacherMangerService service;
	
	@ApiOperation(value = "老师管理列表拉取", notes = "老师管理列表拉取")
	@RequestMapping(value = "/getteacherlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> getTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.getTeacherList(map);
	}
	
	@ApiOperation(value = "老师管理新增", notes = "老师管理新增")
	@RequestMapping(value = "/addteacherlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> addTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.addTeacherList(map);
	}
	
	@ApiOperation(value = "老师管理修改", notes = "老师管理修改")
	@RequestMapping(value = "/updateteacherlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> updateTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.updateTeacherList(map);
	}
	
	@ApiOperation(value = "老师管理删除", notes = "老师管理删除")
	@RequestMapping(value = "/delteacherlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> delTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.delTeacherList(map);
	}
	@ApiOperation(value = "老师管理导出", notes = "老师管理导出")
	@RequestMapping(value = "/expteacherlist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> expTeacherList(@RequestBody HashMap<String,Object> map) {
		return service.expTeacherList(map);
	}
	

}
