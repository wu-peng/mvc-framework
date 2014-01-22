package com.example.entity;

import com.mvc.action.ActionForm;

public class Account extends ActionForm{
	
	public String username;
	public String pwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "username="+this.username+"||"+"pwd="+this.pwd;
	}

}
