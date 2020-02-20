package com.cpg.sprint1.test;

import org.junit.*;

import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.ServiceImpl.ServiceImpl;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IService;

public class UserServiceTest {
	IService service;
	
	@Before
	public void setup() {
		service= new ServiceImpl(new UserDao());
	}
	
	@Test
	public void addUserTest1() {
		String name="Shivani";
		String mail="shiva@gmail.com";
		String pass="123_456sh";
		long num=12345678;
		String gen= "female";
		String role="customer";
		int age=21;
		User u = new User(name,mail,pass,num,gen,age,role);
		service.register(u);
		Assert.assertNotNull(u);
		Assert.assertEquals(name, u.getUserName());
		Assert.assertEquals(mail, u.getEmailId());
		Assert.assertEquals(pass, u.getUserPassword());
		Assert.assertEquals(num, u.getContactNo());
		Assert.assertEquals(gen, u.getGender());
		Assert.assertEquals(age, u.getAge());
		Assert.assertEquals(role, u.getUser_role());
	}
	
	@Test(expected= NullArgumentException.class)
	public void addUserTest2() {
		service.register(null);
	}

}
