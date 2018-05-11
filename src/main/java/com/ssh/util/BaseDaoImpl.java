package com.ssh.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class BaseDaoImpl<T,S extends Serializable> extends BaseHibernate<T, Serializable>{

	
	private Class<T> T;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
//		 ReflectionUtils;
		this.T=(Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("泛型的类型:\n"+T.toString());
	}
	
	
	
	
}
