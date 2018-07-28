package com.ssh.repository;

import java.util.List;
import java.util.Map;

import com.ssh.entity.User;
import com.ssh.util.Page;

public interface UserDao {

	void save(User user);
	
	void update(User user);
	
	void delete(Integer id);
	
	User get(Integer id);
	
	Page<User> page(Page<User> page);
	
	Page<Map<String,Object>> getPage(Page<Map<String,Object>> page);
}
