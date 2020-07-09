package com.apextraining.user.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RequestMapping;

import com.apextraining.user.bo.BankBO;
import com.apextraining.user.bo.ContactBO;
import com.apextraining.user.bo.UserBO;
import com.apextraining.user.bo.UserBoImp;
import com.apextraininguser.vo.Bank;
import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;

@Controller
public class UserController {

	UserBO userBo = null;



	@RequestMapping(value= "/addUserEntry.go")
	public String entryUserPage(@ModelAttribute User user,@Valid User User ,BindingResult bindingResult,Model model) {
		      if (bindingResult.hasErrors()) {
			return "user"; 
			
	}return "contactinfo"; }
	
	@RequestMapping(params = "save",value= "/User.go")
	public String addUserP(@ModelAttribute Contact contact, @ModelAttribute User user) {
		System.out.println("Entry:UserController :addUser()");
		//step 2
		//userBo = new UserBoImp();
		//userBo.addUser(user);
		System.out.println("FirstName : " +user.getFirstName());
	
		System.out.println("Exit:UserController : addUser()");
		return "contactinfo";

	}
	
	@RequestMapping(params = "delete", value= "/User.go")
	public String delUser(@ModelAttribute Contact contact, @ModelAttribute User user) {
		System.out.println("Entry:UserController :delUser()");
		//step 2
		System.out.println("FirstName : " +user.getFirstName());
	
		System.out.println("Exit:UserController : delUser()");
			return "contactinfo";
	}
	
	@RequestMapping(params = "update", value= "/User.go")
	public String updUser(@ModelAttribute Contact contact, @ModelAttribute User user) {
		System.out.println("Entry:UserController :updUser()");
		//step 2
		System.out.println("FirstName : " +user.getFirstName());
	
		System.out.println("Exit:UserController : updateUser()");
			return "contactinfo";
	}

    

}