package com.cpg.sprint1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cpg.sprint1.DaoImpl.TestDaoImpl;
import com.cpg.sprint1.ServiceImpl.TestServiceImpl;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.ITestService;

public class TestServiceTest {
	ITestService service;
	
	@Before
	public void setup() {
		service = new TestServiceImpl(new TestDaoImpl());
	}
	
	@Test(expected=NullArgumentException.class)
	public void addTest1() {
		service.addTest(null);
	}
	
	@Test
	public void addTest2() {
		String name= "EyeTest";
		String cid= "xyz";
		com.cpg.sprint1.entities.Test t= new com.cpg.sprint1.entities.Test(name,cid);
		Assert.assertNotNull(t);
		Assert.assertEquals(name, t.getTestName());
		Assert.assertEquals(cid, t.getCenter_id());
	}

}
