package com.ssh.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssh.entity.User;
import com.ssh.repository.UserDao;
import com.ssh.util.BaseDaoImpl;
import com.ssh.util.Page;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao{

	@SuppressWarnings("serial")
	@Override
	public Page<User> page(Page<User> page) {
		String sql="select * from user where id in (:id) ";
		Map<String,Object> params=new HashMap<String,Object>();
		List<Integer> list=new ArrayList<Integer>();
		list.add(13);
		list.add(14);
		list.add(15);
		params.put("id", list.toArray());
		return super.findPageBySql(page, sql, params);
	}

	@Override
	public Page<Map<String, Object>> getPage(Page<Map<String, Object>> page) {
		String sql="select * from user where id in (?) ";
		List<Integer> list=new ArrayList<Integer>();
		list.add(13);
		list.add(14);
		list.add(15);
		return super.findMapBySql(page, sql, list);
	}


}
