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
public class BankController {

	BankBO bankBo=null;
	
   @RequestMapping(params="save",value= "/Bank.go")
	public String addBank(@ModelAttribute Bank bank,@Valid Bank Bank,BindingResult bindingResult,Model model) {
	      if (bindingResult.hasErrors()) {
	    	  
	    	  return "bankinfo";
	      }
		
		System.out.println("BankName: " +bank.getBankName());
		System.out.println("Exit:UserController : addBank()");
		return "output";

	}
   @RequestMapping(params="update",value= "/Bank.go")
  	public String delBank(@ModelAttribute Bank bank) {
  		
  		System.out.println("BankName: " +bank.getBankName());
  		System.out.println("Exit:UserController : delBank()");
  		return "output";
	}
   @RequestMapping(params="delete",value= "/Bank.go")
 	public String updateBank(@ModelAttribute Bank bank) {
 		
 		System.out.println("BankName: " +bank.getBankName());
 		System.out.println("Exit:UserController : updateBank()");
 		return "output";   }
}