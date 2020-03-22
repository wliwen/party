package com.party.studentmanger.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.mapper.HomeMapper;
@Service
public class HomeService {
		@Autowired
		private HomeMapper mapper;
	public List<HashMap<String, Object>> getNearUser() {
		return mapper.getNearUser();
	}

}
