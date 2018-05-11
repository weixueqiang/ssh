package com.ssh.util;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BaseHibernate<T,S extends Serializable> {


	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	public void save(T T) {
		this.hibernateTemplate.save(T);
	}
	
	
}
