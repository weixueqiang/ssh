package com.ssh.entity;

import javax.annotation.Resource;

public class Test {

	@Resource
	private BaseHibernateTemplate baseHibernateTemplate;
	
	public BaseHibernateTemplate getBaseHibernateTemplate() {
		return this.baseHibernateTemplate;
	}
	
}
