package com.cpg.sprint1.test;

import org.junit.*;

import com.cpg.sprint1.DaoImpl.AppointmentDaoImpl;
import com.cpg.sprint1.ServiceImpl.AppointmentServiceImpl;
import com.cpg.sprint1.entities.Appointment;
import com.cpg.sprint1.exceptions.AppointmentNotFoundException;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IAppointmentService;

public class AppointmentServiceTest {
	IAppointmentService service;
	
	@Before
	public void setup() {
		service= new AppointmentServiceImpl(new AppointmentDaoImpl());
	}
	
	@Test(expected= NullArgumentException.class)
	public void addAppointmentTest1() {
		Appointment a= null;
		service.addAppointment(a);
	}
	
	@Test(expected=AppointmentNotFoundException.class)
	public void removeAppointmentTest() {
		double id=0;
		service.removeAppointment(id);
	}
	
	@Test
	public void approveAppointment() {
		double id= 12344566;
		service.approveAppointment(id, "yes");
	}

}
