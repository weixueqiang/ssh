package com.ssh.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

public class BaseDaoImpl<T, S extends Serializable> extends BaseHibernate<T, Serializable> {

	private Class<T> T;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// ReflectionUtils;
		this.T = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		System.out.println("泛型的类型:\n" + T.toString());
	}

	public T get(S id) {
		Assert.notNull(id, "标识不能为空！");
		return this.hibernateTemplate.get(T, id);
	}

	public void delete(S id) {
		this.hibernateTemplate.delete(this.get(id));
	}

	// select * from ....
	protected Page<T> findPageBySql(Page<T> page, final String sql, Map<String, Object> params) {
		Assert.notNull(page, "分页对象不能为空！");
		Assert.notNull(sql, "查询语句不能为空！");
		Assert.notNull(params, "参数map不能为空！");
		String countSql = "select count(1) from(" + sql+")as countSql" ;
		int count = findInt(countSql, params);
		page.setCount(count);
		if (count < 1) {
			return page;
		}
		this.hibernateTemplate.execute(new HibernateCallback<Page<T>>() {

			@Override
			public Page<T> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				if (!CollectionUtils.isEmpty(params)) {
					for (String key : params.keySet()) {
						Object val = params.get(key);
						if (val != null && val.getClass().isArray()) {
							query.setParameterList(key, (Object[])val);
						} else {
							query.setParameter(key, val);
						}
					}
				}
				query.setFirstResult((page.getCurPage() - 1) * page.getLimit());
				query.setMaxResults(page.getLimit());
				query.setResultTransformer(Transformers.aliasToBean(T));
				page.setData(query.list());
				return page;
			}
		});
		return page;
	}

	public int findInt(final String sql, Map<String, Object> params) {
		return Integer.parseInt(String.valueOf(findUniqueBySql(sql, params)));
	}
	
	public Object findUniqueBySql(final String sql, Map<String, Object> params) {
		Assert.notNull(sql, "查询语句不能为空！");
		Assert.notNull(params, "参数map不能为空！");
		return this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				if (!CollectionUtils.isEmpty(params)) {
					for (String key : params.keySet()) {
						Object val = params.get(key);
						if (val != null && val.getClass().isArray()) {
							query.setParameterList(key, (Object[])val);
						} else {
							query.setParameter(key, val);
						}
					}
				}
				return query.uniqueResult();
			}
		});
	}

	public Page<Map<String,Object>> findMapBySql(Page<Map<String,Object>> page,final String sql,Object... params){
		Assert.notNull(page, "分页对象不能为空！");
		Assert.notNull(sql, "查询语句不能为空！");
		Assert.notNull(params, "参数map不能为空！");
		String countSql = "select count(1) from(" + sql+")as countSql" ;
		int count = findIntObj(countSql, params);
		page.setCount(count);
		if (count < 1) {
			return page;
		}
		this.hibernateTemplate.execute(new HibernateCallback<Page<Map<String,Object>>>() {

			@Override
			public Page<Map<String, Object>> doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
				query.setFirstResult((page.getCurPage()-1)*page.getLimit());
				query.setMaxResults(page.getLimit());
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				page.setData(query.list());
				return page;
			}
			
		});
		return page;
	}

	public int findIntObj(String sql, Object[] params) {
		return Integer.parseInt(String.valueOf(findUniqueByObj(sql, params)));
	}
	
	public Object findUniqueByObj(final String sql, Object[] params) {
		Assert.notNull(sql, "查询语句不能为空！");
		Assert.notNull(params, "参数不能为空！");
		return this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(sql);
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
				return query.uniqueResult();
			}
		});
	}
	
}
