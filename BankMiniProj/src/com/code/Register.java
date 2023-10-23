package com.code;

public class Register {
	private String uname;
	private String password;
	
	public Register() {
		
	}
	public Register(String uname,String password) {
		this.uname=uname;
		this.password=password;
	}
	
	public String getUname() {
		return uname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
