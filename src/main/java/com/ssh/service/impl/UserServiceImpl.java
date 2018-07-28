package com.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.ssh.entity.User;
import com.ssh.repository.UserDao;
import com.ssh.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}

}
