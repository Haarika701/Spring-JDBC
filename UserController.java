package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.bo.UserBO;
import com.user.vo.User;

@Controller
public class UserController {

	UserBO userBo = null;

	@RequestMapping(value= "/addUserEntry.go")
	public String entryUserPage(@ModelAttribute User user) {
		return "user";
	}
	@RequestMapping(value= "/addUser.go")
	public String addUser(@ModelAttribute User user) {
		System.out.println("Entry:UserController :addUser()");
		//step 2
		System.out.println("FirstName : " +user.getFirstName());
		System.out.println("Exit:UserController : addUser()");
		return "success1";

	}




}