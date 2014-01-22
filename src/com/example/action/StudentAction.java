package com.example.action;

import com.example.entity.Student;
import com.mvc.action.Action;
import com.mvc.action.ActionForm;

public class StudentAction implements Action{

	@Override
	public String execute(ActionForm form) {
		Student stu = (Student)form;
		System.out.println(stu.toString());
		return "success";
	}

}
