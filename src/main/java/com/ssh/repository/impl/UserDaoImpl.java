package com.ssh.repository.impl;

import org.springframework.stereotype.Repository;

import com.ssh.entity.User;
import com.ssh.repository.UserDao;
import com.ssh.util.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao{

}
