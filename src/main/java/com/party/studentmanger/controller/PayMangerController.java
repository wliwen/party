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
import com.party.studentmanger.service.PayMangerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "缴费接口")
@RestController
@RequestMapping("/party")
public class PayMangerController {
	@Autowired
	private PayMangerService service;
	
	@ApiOperation(value = "缴费列表拉取", notes = "缴费列表拉取")
	@RequestMapping(value = "/getpaylist", method = RequestMethod.POST)
	@MustToken
	public List<HashMap<String,Object>> getPayList(@RequestBody HashMap<String,Object> map) {
		return service.getPayList(map);
	}
	@ApiOperation(value = "缴费存入", notes = "缴费存入")
	@RequestMapping(value = "/addpay", method = RequestMethod.POST)
	@MustToken
	public Boolean addPay(@RequestBody HashMap<String,Object> map) {
		return service.addPay(map);
	}
}
