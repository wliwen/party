package com.party.studentmanger.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class SystemUsersEntity {
	String ID;
	String userName;
	String userPassword;
	public SystemUsersEntity(String iD, String userName, String userPassword, String ID) {
		super();
		this.ID = ID;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
