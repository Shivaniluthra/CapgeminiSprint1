package com.cpg.sprint1.entities;

import java.util.Date;

public class Appointment {
	private double appointmentId;
	private String status;
	private String center_id;
	private String test_id;
	private String app_date;
	
	public Appointment(String center_id, String test_id, String app_date) {
		this.center_id = center_id;
		this.test_id = test_id;
		this.app_date= app_date;
	}
	
	public Appointment() {
	}

	public String getCenter_id() {
		return center_id;
	}

	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}

	public String getTest_id() {
		return test_id;
	}

	public void setTest_id(String test_id) {
		this.test_id = test_id;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}

	public double getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(double appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
