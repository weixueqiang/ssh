package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.controller.MainController;
import com.ssh.entity.Person;
import com.ssh.repository.PersonRepository;
import com.ssh.service.PersonService;

public class ServiceTest2 {
	
	ClassPathXmlApplicationContext ctx;
	PersonService bean;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml",
				"classpath:META-INF/spring-mvc.xml");
		bean= ctx.getBean("personService", PersonService.class);
	}
	
	@Test
	public void save() {
		System.out.println(bean);
		Person entity=new Person();
		entity.setUsername("ceshi!service");
		bean.savePerson();
	}
	
	@Test
	public void objtest() {
		MainController obj= ctx.getBean("mainController", MainController.class);
		System.out.println(obj);
		obj.savePerson();
	}
	
	@After
	public void destory() {
		ctx.close();
	}
}
