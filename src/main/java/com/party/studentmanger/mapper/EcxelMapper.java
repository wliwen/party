package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

import com.party.studentmanger.entity.PartyEntity;
import com.party.studentmanger.entity.TeacherEntity;

public interface EcxelMapper {

	List<TeacherEntity> exportTeacher(HashMap map);

	List<PartyEntity> exportParty(HashMap map);

}
