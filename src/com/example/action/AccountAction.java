package com.example.action;

import com.example.entity.Account;
import com.mvc.action.Action;
import com.mvc.action.ActionForm;

public class AccountAction implements Action{

	@Override
	public String execute(ActionForm form) {
		Account acc = (Account)form;
		System.out.println(acc.toString());
		return "fail";
	}

}
