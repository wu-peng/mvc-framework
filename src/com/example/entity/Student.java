package com.example.entity;

import com.mvc.action.ActionForm;

public class Student extends ActionForm{
	
	public String name;
	public String address;
	
	public Student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "name="+this.name+"||"+"address="+this.address;
	}
}
