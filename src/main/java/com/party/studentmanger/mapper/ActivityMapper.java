package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface ActivityMapper {
	Integer getTotal(HashMap<String, Object> param);

	List getList(HashMap<String, Object> param);

	Integer addTeacherList(HashMap<String, Object> map);

	List checkID(String ID);

	Integer updateTeacherList(HashMap<String, Object> map);

	Integer delTeacherList(HashMap<String, Object> map);
}
