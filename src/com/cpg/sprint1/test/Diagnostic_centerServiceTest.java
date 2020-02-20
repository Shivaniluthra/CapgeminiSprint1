package com.cpg.sprint1.test;

import org.junit.*;

import com.cpg.sprint1.DaoImpl.Diagnostic_centerDaoImpl;
import com.cpg.sprint1.ServiceImpl.Diagnostic_centerServiceImpl;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.exceptions.CenterNotFoundException;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IDiagnostic_centerService;

public class Diagnostic_centerServiceTest {
	IDiagnostic_centerService service;
	
	@Before
	public void setup() {
		service = new Diagnostic_centerServiceImpl(new Diagnostic_centerDaoImpl());
	}
	
	@Test(expected=NullArgumentException.class)
	public void addCenterTest1() {
		Diagnostic_center dc=null;
		service.addCenter(dc);
	}
	
	@Test
	public void addCenterTest2() {
		String name= "centerxy";
		long num= 1234567890;
		String address= "m266";
		Diagnostic_center dc= new Diagnostic_center(name,num, address);
		Diagnostic_center d =service.addCenter(dc);
		Assert.assertNotNull(d);
		Assert.assertEquals(name, dc.getCenterName());
		Assert.assertEquals(num, dc.getContact_no());
		Assert.assertEquals(address, dc.getAddress());
	}
	
	@Test(expected=CenterNotFoundException.class)
	public void removeCenterTest() {
		String id=null;
		service.removeCenter(null);
	}

}
