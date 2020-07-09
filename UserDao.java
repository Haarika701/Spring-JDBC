package com.user.dao;

import com.user.vo.User;

public interface UserDao {
	

		public User getUser(int id);
		public void addUser(User user);
		public void updateUser(User user);
		public void delUser(int id);
	}



