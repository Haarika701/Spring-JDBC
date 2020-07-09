package com.apex.service;

 import javax.jws.soap.SOAPBinding.Use;

import com.apex.service.user.User;
import com.apex.user.UserDao;

public class UserService {

	public void assUser(User user) {
		UserDao userDAO = new UserDao();
		userDAO.addUser(user);
	}
	
	public User getUser(int id) 
	{
		System.out.println("Start : UserService : getUser()");
		UserDao userDAO = new UserDao();
		User user = userDAO.getUser(id);
		System.out.println("END : UserService : getUser()");
		return user;
	}
	public void updateUser(User user) {
		UserDao userDAO = new UserDao();
		userDAO.updateUser(user);
	}
	public void deleteUser(int id) {
		UserDao userDAO = new UserDao();
		userDAO.deleteUser(id);
	}

	public void addUser(Use user) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
