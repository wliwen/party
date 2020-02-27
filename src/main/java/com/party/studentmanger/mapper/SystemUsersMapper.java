package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

import com.party.studentmanger.entity.SystemUsersEntity;

/**
 * 类文件说明：系统用户相关信息
 * */
public interface SystemUsersMapper {
	SystemUsersEntity loginSystem(HashMap<String, String> map);

	SystemUsersEntity getUserByID(String userid);

	List<HashMap<String, Object>> getMenu(HashMap<String, String> map);
	
}
