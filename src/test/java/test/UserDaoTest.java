package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.entity.Person;
import com.ssh.entity.User;
import com.ssh.repository.PersonRepository;
import com.ssh.service.UserService;
import com.ssh.service.impl.UserServiceImpl;

public class UserDaoTest {

	
	ClassPathXmlApplicationContext ctx;
	UserService bean;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml",
				"classpath:META-INF/spring-mvc.xml");
		bean= ctx.getBean("userService", UserService.class);
	}
	
	@Test
	public void save() {
		User entity=new User();
		entity.setUsername("ceshi!");
		bean.save(entity);
	}
	
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
