package com.party.studentmanger.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.mapper.PartyMangerMapper;

@Service
public class PartyMangerService {
	@Autowired
	private PartyMangerMapper mapper;
	public List<HashMap<String, Object>> getPartyList(HashMap<String, Object> param) {
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

	public Boolean addPartyList(HashMap<String, Object> map) {
		map.put("create_date",new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
		 if(mapper.addPartyList(map) != null) {
			 return true;
		 }else {
			 return false;
		 }
	}

	public Boolean updatePartyList(HashMap<String, Object> map) {
		 if(mapper.updatePartyList(map) != null) {
			 return true;
		 }else {
			 return false;
		 }
	}

	public List<HashMap<String, Object>> delPartyList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, Object>> expPartyList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}
//stu@2020@number
	public String getAutoId() {
		String id= "stu@"+System.currentTimeMillis();
		return id;
	}
}
