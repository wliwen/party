package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface PartyMangerMapper {
	Integer getTotal(HashMap<String, Object> param);

	List getList(HashMap<String, Object> param);

	Integer addPartyList(HashMap<String, Object> map);

	List checkID(String ID);

	Integer updatePartyList(HashMap<String, Object> map);

//	String getAutoId();
}
