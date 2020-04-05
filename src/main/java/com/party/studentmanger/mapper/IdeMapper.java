package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface IdeMapper {
	Integer getTotal(HashMap<String, Object> param);

	List getList(HashMap<String, Object> param);

	Integer addTeacherList(HashMap<String, Object> map);

	List checkID(String ID);

	Integer updateTeacherList(HashMap<String, Object> map);

	Integer deliList(HashMap<String, Object> map);
}
