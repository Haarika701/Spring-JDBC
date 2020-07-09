package com.apextraining.user.dao;

import com.apextraininguser.vo.Bank;
import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;

public interface BankDao {
	

	public User getBank(int id3);
	public void addBank(Bank bank);
	public void updateBank(Bank bank);
	public void delBank(int id3);
	}



