package com.apextraining.user.bo;

import com.apextraininguser.vo.User;

public interface UserBO {

	public User getUser(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void delUser(int id);
}
