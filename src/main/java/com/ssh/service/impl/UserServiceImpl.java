package com.ssh.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.entity.User;
import com.ssh.repository.UserDao;
import com.ssh.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
//	@Transactional(rollbackFor=Exception.class)
//	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
//	@Transactional(rollbackFor=Exception.class,propagation=Propagation.SUPPORTS)
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
//	@Transactional(propagation=Propagation.NEVER)
//	@Transactional(propagation=Propagation.MANDATORY)
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.NESTED)
	public void save(User user) {
		userDao.save(user);
	}

}
