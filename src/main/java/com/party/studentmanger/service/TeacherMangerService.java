package com.party.studentmanger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.mapper.TeacherMangerMapper;
@Service
public class TeacherMangerService {
	@Autowired
	private TeacherMangerMapper mapper;
	public List<HashMap<String, Object>> getTeacherList(HashMap<String, Object> param) {
		List list=new ArrayList<HashMap<String, Object>>();
		//开使处理分页
		//获取总数
		Integer total= mapper.getTotal(param);
		Object oNum=param.get("pageNum");
		Object oSize=param.get("pageSize");
		Integer start_num=(Integer.valueOf(oNum.toString())-1)*(Integer.valueOf(oSize.toString()));
		param.put("start_num", start_num);
		param.put("end_num", Integer.valueOf(oSize.toString()));
		list=mapper.getList(param);
		if(list.size()>0) {
		((HashMap<String, Object>) list.get(0)).put("total",total);
		}
		return list;
	}

	public Boolean addTeacherList(HashMap<String, Object> map) {
		map.put("user_password", "123456");
		map.put("create_date",new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
		 if(mapper.addTeacherList(map) != null) {
			 return true;
		 }else {
			 return false;
		 }
	}

	public Boolean updateTeacherList(HashMap<String, Object> map) {
		 if(mapper.updateTeacherList(map) != null) {
			 return true;
		 }else {
			 return false;
		 }
	}

	public Boolean delTeacherList(HashMap<String, Object> map) {
		if(mapper.delTeacherList(map) != null) {
			 return true;
		 }else {
			 return false;
		 }
	}

	public List<HashMap<String, Object>> expTeacherList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean checkID(String ID) {
		if(mapper.checkID(ID).size()<=0) {
			return false;
		}else {
			return true;
		}
	}

}
