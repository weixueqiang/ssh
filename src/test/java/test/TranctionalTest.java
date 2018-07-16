package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.service.PersonService;
import com.ssh.service.TestService;

/*
 *  TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
	TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
	TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
	TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
	TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
	TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
	TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，
	则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
 */
public class TranctionalTest {

	ClassPathXmlApplicationContext ctx;
	TestService bean;
	
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml",
				"classpath:META-INF/spring-mvc.xml");
		bean= ctx.getBean("testService", TestService.class);
	}
	
	/**
	 * 
	 * TestService 中无事务
	 * PersonService 中有 @Transactional(rollbackFor=Exception.class) 
	 * UserService 中有 @Transactional(rollbackFor=Exception.class)
	 * 默认PROPAGATION_REQUIRED,如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务
	 * 所以PersonService和UserService会创建一个新的事务
	 */
	@Test
	public void usedNoTrantion() {
		bean.test();
	}
	
	/**
	 * 
	 * TestService 中有 @Transactional(rollbackFor=Exception.class)
	 * PersonService 中无事务
	 * UserService 中无事务
	 * 事务传递..
	 * 所以PersonService和UserService在同一个的事务中,若一方报错,回滚
	 */
	@Test
	public void usedHasTranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	/**
	 * 方法中都有默认的传递规则
	 * TestService 中有 @Transactional(rollbackFor=Exception.class)
	 * PersonService 中有 @Transactional(rollbackFor=Exception.class)
	 * UserService 中有 @Transactional(rollbackFor=Exception.class)
	 * 事务传递..
	 * 所以PersonService和UserService在同一个的事务中,若一方报错,回滚
	 */
	@Test
	public void allHasDefaultTranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	/**
	 * Propagation.REQUIRES_NEW 
	 * TestService 中有 @Transactional(rollbackFor=Exception.class)
	 * PersonService 中有 @Transactional(rollbackFor=Exception.class)
	 * UserService @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
	 * propagation=Propagation.REQUIRES_NEW,创建一个新的事务(完全独立)，如果当前存在事务，则把当前事务挂起(独立与当前事务外),
	 * 尽管当前事务报错,UserService也不回滚,反之UserService的事务也不影响TestService中的其它业务,前提是对UserService方法进行
	 * 了try catch 
	 */
	@Test
	public void REQUIRES_NEWTranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	/**
	 * Propagation.SUPPORTS 
	 * TestService 中有 @Transactional(rollbackFor=Exception.class) 和 没有的情况
	 * PersonService 中有 @Transactional(rollbackFor=Exception.class)
	 * UserService @Transactional(rollbackFor=Exception.class,propagation=Propagation.SUPPORTS)
	 * 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行
	 */
	@Test
	public void PROPAGATION_SUPPORTSTranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	/**
	 * 
	 * 以非事务方式运行，如果当前存在事务，则抛出异常。
	 */
	@Test
	public void PROPAGATION_NEVERTranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	/**
	 * 
	 * 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常
	 */
	@Test
	public void PROPAGATION_MANDATORYranction() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	/**
	 * 需要先设置事务管理器nestedTransactionAllowed的值为true
	 * <property name="nestedTransactionAllowed" value="true"/>
	 * 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
	 * 即当前事务回滚它也回滚
	 */
	
	@Test
	public void PROPAGATION_NESTED() {
		System.err.println("...1");
		bean.test();
		System.err.println("...2");
	}
	
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
	
}
