package com.party.studentmanger.mapper;

import java.util.HashMap;
import java.util.List;

public interface PayMangerMapper {

	List<HashMap<String, Object>> getPayList(HashMap<String,Object> map);

}
