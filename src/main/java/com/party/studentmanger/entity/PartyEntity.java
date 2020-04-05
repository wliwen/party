package com.party.studentmanger.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class PartyEntity {
	@Excel(name = "姓名",width=10)
    private String user_name;

    @Excel(name = "党支部",width=15)
    private String in_party_dept;

    @Excel(name = "籍贯",width=10)
    private String navite_place;
    
    @Excel(name = "学历",width=10)
    private String education;
    
    @Excel(name = "入党时间",width=20)
    private String in_date;
	@Excel(name = "转正时间",width=20)
    private String correction_date;
	@Excel(name = "本地/外地",width=10)
    private String in_out_val;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getIn_party_dept() {
		return in_party_dept;
	}
	public void setIn_party_dept(String in_party_dept) {
		this.in_party_dept = in_party_dept;
	}
	public String getNavite_place() {
		return navite_place;
	}
	public void setNavite_place(String navite_place) {
		this.navite_place = navite_place;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getIn_date() {
		return in_date;
	}
	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}
	public String getCorrection_date() {
		return correction_date;
	}
	public void setCorrection_date(String correction_date) {
		this.correction_date = correction_date;
	}
	public String getIn_out_val() {
		return in_out_val;
	}
	public void setIn_out_val(String in_out_val) {
		this.in_out_val = in_out_val;
	}
	public PartyEntity(String user_name, String in_party_dept, String navite_place, String education, String in_date,
			String correction_date, String in_out_val) {
		super();
		this.user_name = user_name;
		this.in_party_dept = in_party_dept;
		this.navite_place = navite_place;
		this.education = education;
		this.in_date = in_date;
		this.correction_date = correction_date;
		this.in_out_val = in_out_val;
	}
	
}
