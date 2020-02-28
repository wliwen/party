package com.party.studentmanger.entity;

public class ResponseResult {
	private int code; //自定义状态码
	private boolean flag; //自定义boolean
	private String content; //自定义报文类容
	private Object object;//自定义元素
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public ResponseResult(int code, boolean flag, String content, Object object) {
		super();
		this.code = code;
		this.flag = flag;
		this.content = content;
		this.object = object;
	}
	public ResponseResult() {
		// TODO Auto-generated constructor stub
	}
	

}
