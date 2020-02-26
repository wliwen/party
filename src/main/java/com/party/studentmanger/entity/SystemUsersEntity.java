package com.party.studentmanger.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class SystemUsersEntity {
	String user_id;
	Integer dept_id;
	String user_name;
	Integer user_sex;
	Integer user_age;
	String user_identity;
	Integer is_used;
	String user_password;
	Integer power;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getdept_id() {
		return dept_id;
	}
	public void setdept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
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
	public Integer getIs_used() {
		return is_used;
	}
	public void setIs_used(Integer is_used) {
		this.is_used = is_used;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public SystemUsersEntity() {
		super();
		this.user_id = user_id;
		this.dept_id = dept_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_age = user_age;
		this.user_identity = user_identity;
		this.is_used = is_used;
		this.user_password = user_password;
		this.power = power;
	}
	
}
