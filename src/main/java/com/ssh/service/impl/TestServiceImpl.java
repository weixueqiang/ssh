package com.ssh.service.impl;

import com.ssh.entity.User;
import com.ssh.service.PersonService;
import com.ssh.service.TestService;
import com.ssh.service.UserService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by XRog
 * On 2/1/2017.12:58 AM
 */
@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private UserService userService;
	
	@Resource
	private PersonService personService;
	
	@Transactional(rollbackFor=Exception.class)
	public String test() {
		User user=new User();
		user.setPassword("password");
		user.setSalt("salt");
		user.setUsername("--->>>");
		try {
			userService.save(user);
		}catch(Exception e) {
			System.err.println("userSerivce..>>>>>>");
			e.printStackTrace();
		}
		personService.savePerson();
		return null;
	}
	
}