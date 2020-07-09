package com.apextraining.user.bo;

import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;

public interface ContactBO {

	public User getContact(int id1);
	public void addContact(Contact contact);
	public void updateContact(Contact contact);
	public void delContact(int id1);
}
