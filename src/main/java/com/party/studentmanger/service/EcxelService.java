package com.party.studentmanger.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.party.studentmanger.entity.PartyEntity;
import com.party.studentmanger.entity.TeacherEntity;
import com.party.studentmanger.mapper.EcxelMapper;
@Service
public class EcxelService {
@Autowired
private EcxelMapper mapper;
	public List<TeacherEntity> exportTeacher(HashMap map) {
		return mapper.exportTeacher(map);
		
	}
	public List<PartyEntity> exportParty(HashMap map) {
		return mapper.exportParty(map);
		
	}

}
