package com.party.studentmanger.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TeacherEntity {
	@Excel(name = "姓名",width=15)
    private String user_name;

    @Excel(name = "性别",width=10)
    private String user_sex_val;

    @Excel(name = "年龄",width=10)
    private Integer user_age;
    
    @Excel(name = "身份证",width=20)
    private String user_identity;
    
	@Excel(name = "邮箱",width=20)
    private String email;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_sex_val() {
		return user_sex_val;
	}

	public void setUser_sex_val(String user_sex_val) {
		this.user_sex_val = user_sex_val;
	}

	public Integer getUser_age() {
		return user_age;
	}

	public void setUser_age(Integer user_age) {
		this.user_age = user_age;
	}

	public String getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(String user_identity) {
		this.user_identity = user_identity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TeacherEntity(String user_name, String user_sex_val, Integer user_age, String user_identity, String email) {
		super();
		this.user_name = user_name;
		this.user_sex_val = user_sex_val;
		this.user_age = user_age;
		this.user_identity = user_identity;
		this.email = email;
	}

	
}
