package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface UserMangerMapper {

	Integer getTotal(HashMap<String, Object> param);

	List getList(HashMap<String, Object> param);

	Integer fireUser(String iD);

}
