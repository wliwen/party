package com.party.studentmanger.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.mapper.PayMangerMapper;
@Service
public class PayMangerService {
@Autowired
private PayMangerMapper mapper;
	public List<HashMap<String, Object>> getPayList(HashMap<String,Object> map) {
		return mapper.getPayList(map);
	}

}
