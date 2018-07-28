package test;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.entity.Person;
import com.ssh.entity.User;
import com.ssh.repository.PersonRepository;
import com.ssh.repository.UserDao;
import com.ssh.service.UserService;
import com.ssh.service.impl.UserServiceImpl;
import com.ssh.util.Page;

public class UserDaoTest {

	
	ClassPathXmlApplicationContext ctx;
	UserService bean;
	UserDao dao;
	
	
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml",
				"classpath:META-INF/spring-mvc.xml");
		bean= ctx.getBean("userService", UserService.class);
		dao=ctx.getBean("userDao",UserDao.class);
	}
	
	
	@Test
	public void save1() {
		for (int i = 0; i < 10; i++) {
			User entity=new User();
			String insert="_7"+i;
			entity.setUsername("ceshi!"+insert);
			entity.setPassword("1232131"+insert);
			entity.setSalt("salt"+insert);
			dao.save(entity);
		}
	}
	
	@Test
	public void update() {
		User entity=new User();
		String insert="_4";
		entity.setId(143);
		entity.setUsername("ceshi!"+insert);
		entity.setPassword("1232131"+insert);
		entity.setSalt("salt"+insert);
		dao.update(entity);
	}
	
	@Test
	public void get() {
		User user = dao.get(14);
		System.out.println(user+"\n");
	}
	
	@Test
	public void delete() {
		dao.delete(14);
	}
	
	@Test
	public void page() {
		Page<User> page = new Page<>();
		page = dao.page(page);
		System.out.println(page.getCount()+"\n");
		System.out.println(page);
		List<User> data = page.getData();
		data.forEach((o)->System.out.println(o));
	}
	
	@Test
	public void page2() {
		Page<Map<String,Object>> page = new Page<>();
		page = dao.getPage(page);
		System.out.println(page.getCount()+"\n");
		System.out.println(page);
		List<Map<String,Object>> data = page.getData();
		data.forEach((o)->System.out.println(o));
	}
	
	
	
	@Test
	public void save() {
		User entity=new User();
		String insert="_2";
		entity.setId(14);
		entity.setUsername("ceshi!"+insert);
		entity.setPassword("1232131"+insert);
		entity.setSalt("salt"+insert);
		bean.save(entity);
	}
	
	@Test
	public void u() {
		User entity=new User();
		String insert="_2";
		entity.setId(14);
		entity.setUsername("ceshi!"+insert);
		entity.setPassword("1232131"+insert);
		entity.setSalt("salt"+insert);
		bean.save(entity);
	}
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
