package com.apextraining.user.dao;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.apextraininguser.vo.User;

@Service
public class UserDaoImpl implements UserDao{

	private UserDao userDao;
	private HibernateTemplate hibernateTemplate;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao; }

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
		public User getUser(int id) {
		((UserDao) hibernateTemplate).getUser(id);
			return this.userDao.getUser(id);

		}
		@Override
		@Transactional
		public void addUser(User user) {
			hibernateTemplate.save(user);
			this.userDao.addUser(user);
		}
		@Override
		@Transactional
		public void updateUser(User user) {
			hibernateTemplate.update(user);
			this.userDao.updateUser(user);;

		}
		@Override
		@Transactional
		public void delUser(int id) {
			hibernateTemplate.delete(id);
			this.userDao.delUser(id);

		}

	}
