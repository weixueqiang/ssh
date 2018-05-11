package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.entity.Person;
import com.ssh.repository.PersonRepository;
import com.ssh.repository.impl.PersonRepositoryImpl;

public class DaoTest {
	
	ClassPathXmlApplicationContext ctx;
	PersonRepository bean;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml",
				"classpath:META-INF/spring-mvc.xml");
		bean= ctx.getBean("personRepository", PersonRepository.class);
	}
	
	@Test
	public void save() {
		System.out.println(bean);
		Person entity=new Person();
		entity.setUsername("ceshi!");
		bean.save(entity);
	}
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
