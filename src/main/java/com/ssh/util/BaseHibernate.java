package com.ssh.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Component
@Transactional
public class BaseHibernate<T,S extends Serializable> {

	protected Logger logger = Logger.getLogger("test");
	
	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	public void save(T entity) {
		Assert.notNull(entity, "对象不能为空！");
		this.hibernateTemplate.saveOrUpdate(entity);
	}
	
	public void update(T entity) {
		Assert.notNull(entity, "对象不能为空！");
		this.hibernateTemplate.update(entity);
	}
	
	
}
