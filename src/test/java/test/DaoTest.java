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
		Person entity=new Person();
		String insert="_2";
		entity.setUsername("ceshi!"+insert);
		entity.setAddress("address"+insert);
		entity.setCreated(System.currentTimeMillis());
		entity.setPhone("15859578615"+insert);
		entity.setRemark("remark"+insert);
		bean.save(entity);
	}
	
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
