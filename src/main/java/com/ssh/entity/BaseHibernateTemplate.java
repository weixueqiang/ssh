package com.ssh.entity;

import javax.annotation.Resource;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BaseHibernateTemplate extends HibernateTemplate{

	@Override
	protected void checkWriteOperationAllowed(Session session) throws InvalidDataAccessApiUsageException {
		session.setFlushMode(FlushMode.COMMIT);
		super.checkWriteOperationAllowed(session);
	}
	
	@Override
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		  super.setSessionFactory(sessionFactory);
	}
}
