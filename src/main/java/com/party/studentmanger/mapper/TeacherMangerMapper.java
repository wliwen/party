package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface TeacherMangerMapper {

	Integer getTotal(HashMap<String, Object> param);

	List getList(HashMap<String, Object> param);

}
