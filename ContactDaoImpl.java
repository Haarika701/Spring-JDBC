package com.apextraining.user.dao;

import com.apextraininguser.vo.Contact;
import com.apextraininguser.vo.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

public class ContactDaoImpl implements ContactDao{

	private ContactDao contactDao;
	private HibernateTemplate hibernateTemplate;

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao; }
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
	public User getContact(int id1) {
		((ContactDao) hibernateTemplate).getContact(id1);
		return this.contactDao.getContact(id1);
	}

	@Override
	@Transactional
	public void addContact(Contact contact) {
		hibernateTemplate.save(contact);
		this.contactDao.addContact(contact);

	}

	@Override
	@Transactional
	public void updateContact(Contact contact) {
		hibernateTemplate.update(contact);
		this.contactDao.updateContact(contact);

	}

	@Override
	@Transactional
	public void delContact(int id1) {
		hibernateTemplate.delete(id1);
		this.contactDao.delContact(id1);

	}

}