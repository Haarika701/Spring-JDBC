package com.apextraining.user.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.apextraininguser.vo.Bank;
import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;

public class BankDaoImpl implements BankDao{
	
	private BankDao bankDao;
	private HibernateTemplate hibernateTemplate;
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao; }
	
		private static SessionFactory sessionFactory;

		private static org.hibernate.cfg.Configuration configuration;

		// Create the initial SessionFactory from the default configuration files
		static {
			try {
				configuration = new org.hibernate.cfg.Configuration();
				sessionFactory = configuration.configure().buildSessionFactory();
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}

	@Override
	@Transactional
	public User getBank(int id2) {
		((BankDao) hibernateTemplate).getBank(id2);
		return this.bankDao.getBank(id2);
	}

	@Override
	@Transactional
	public void addBank(Bank bank) {
		((BankDao) hibernateTemplate).addBank(bank);
		this.bankDao.addBank(bank);
		
	}

	@Override
	@Transactional
	public void updateBank(Bank bank) {
		((BankDao) hibernateTemplate).updateBank(bank);
		this.bankDao.updateBank(bank);
		
	}

	@Override
	@Transactional
	public void delBank(int id2) {
		hibernateTemplate.delete(id2);
		this.bankDao.delBank(id2);
		
	}

}