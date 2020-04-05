package com.party.studentmanger.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.party.studentmanger.elementtype.MustToken;
import com.party.studentmanger.entity.PartyEntity;
import com.party.studentmanger.entity.TeacherEntity;
import com.party.studentmanger.service.EcxelService;
import com.party.studentmanger.utils.ExcelUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "excel接口")
@RestController
@RequestMapping("/party")
public class ExcelController {
@Autowired
private EcxelService service;

@ApiOperation(value = "老师excel导出", notes = "excel导出")
@RequestMapping(value = "/exportTeacher", method = RequestMethod.POST)
public void exportTeacher(HttpServletResponse response,@RequestBody HashMap map) {
	List<TeacherEntity> list = service.exportTeacher(map);
	ExcelUtils.exportExcel(list,"sheet1", TeacherEntity.class, "model.xls", response);
}
@ApiOperation(value = "党员excel导出", notes = "excel导出")
@RequestMapping(value = "/exportParty", method = RequestMethod.POST)
public void exportParty(HttpServletResponse response,@RequestBody HashMap map) {
	List<PartyEntity> list = service.exportParty(map);
	ExcelUtils.exportExcel(list,"sheet1", PartyEntity.class, "model.xls", response);
}
}
