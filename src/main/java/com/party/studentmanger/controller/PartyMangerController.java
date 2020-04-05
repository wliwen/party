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
import com.party.studentmanger.service.PartyMangerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "学生管理接口")
@RestController
@RequestMapping("/party")
public class PartyMangerController {
	@Autowired
	private PartyMangerService service;
	
	@ApiOperation(value = "学生管理列表拉取", notes = "学生管理列表拉取")
	@RequestMapping(value = "/getpartylist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> getpartyList(@RequestBody HashMap<String,Object> map) {
		return service.getPartyList(map);
	}
	
	@ApiOperation(value = "学生管理新增", notes = "学生管理新增")
	@RequestMapping(value = "/addpartylist", method = RequestMethod.POST)
	@MustToken
	public Boolean addpartyList(@RequestBody HashMap<String,Object> map) {
		return service.addPartyList(map);
	}
	
	@ApiOperation(value = "学生管理修改", notes = "学生管理修改")
	@RequestMapping(value = "/updatepartylist", method = RequestMethod.POST)
	@MustToken
	public Boolean updatepartyList(@RequestBody HashMap<String,Object> map) {
		return service.updatePartyList(map);
	}
	@ApiOperation(value = "学生管理删除", notes = "学生管理删除")
	@RequestMapping(value = "/delpartyList", method = RequestMethod.POST)
	@MustToken
	public Boolean delpartyList(@RequestBody HashMap<String,Object> map) {
		return service.delpartyList(map);
	}
	@ApiOperation(value = "学生管理导出", notes = "学生管理导出")
	@RequestMapping(value = "/exppartylist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> exppartyList(@RequestBody HashMap<String,Object> map) {
		return service.expPartyList(map);
	}
	@ApiOperation(value = "自动获取工号", notes = "自动获取工号")
	@RequestMapping(value = "/getautoid", method = RequestMethod.GET)
	@MustToken
	public String getAutoId() {
		return service.getAutoId();
	}

}
