package com.ssh.entity;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class BaseDao {

	
	
	@Resource
	protected BaseHibernateTemplate baseHibernateTemplate;
	
	public BaseHibernateTemplate getBaseHibernateTemplate() {
		return this.baseHibernateTemplate;
	}
	
	
//	@Resource
//	protected HibernateTemplate hibernateTemplate;
//	
//	public HibernateTemplate gethibernateTemplate() {
//		return this.hibernateTemplate;
//	}
//	
//	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//		this.hibernateTemplate=hibernateTemplate;
//	}
}
