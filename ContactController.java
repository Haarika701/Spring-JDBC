package com.apextraining.user.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apextraining.user.bo.BankBO;
import com.apextraining.user.bo.ContactBO;
import com.apextraining.user.bo.UserBO;
import com.apextraininguser.vo.Bank;
import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;

@Controller
public class ContactController {

	
	
	ContactBO contactBo =null;

	@RequestMapping(value= "/addContactEntry.go")
	public String entryUserPage(@ModelAttribute Contact contact,@Valid Contact Contact ,BindingResult bindingResult,Model model) {
		      if (bindingResult.hasErrors()) {
			return "contactinfo"; 
			
	} return "bankinfo";}

	@RequestMapping(params="save" ,value= "/ContactInfo.go")
	public String addContact(@ModelAttribute Contact contact) {
	     
		System.out.println("Entry:UserController :addContact()");
		//step 2
		System.out.println("Address : " +contact.getAddress());
	
		System.out.println("Exit:UserController : addContact()");
		return "bankinfo";

	}
	
	
	@RequestMapping(params="delete" ,value= "/ContactInfo.go")
	public String delContact(@ModelAttribute Contact contact,  @ModelAttribute Bank bank) {
		System.out.println("Entry:UserController :addContact()");
		//step 2
		System.out.println("Address : " +contact.getAddress());
	
		System.out.println("Exit:UserController : delContact()");
		return "bankinfo";

	}
	@RequestMapping(params="update" ,value= "/ContactInfo.go")
	public String updateContact(@ModelAttribute Contact contact,  @ModelAttribute Bank bank) {
		System.out.println("Entry:UserController :addContact()");
		//step 2
		System.out.println("Address : " +contact.getAddress());
	
		System.out.println("Exit:UserController : updateContact()");
		return "bankinfo";

	}

}