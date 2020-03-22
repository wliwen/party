package com.party.studentmanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.mapper.UserMangerMapper;

@Service
public class UserMangerService {
	@Autowired
	private UserMangerMapper mapper;
	public List<HashMap<String, Object>> getUserList(HashMap<String, Object> param) {
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
	public Boolean fireUser(String iD) {
		if(mapper.fireUser(iD)== 1) {
			return true;
		}else {
			return false;
		}
	}

}
