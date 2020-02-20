package com.cpg.sprint1.entities;


public class Diagnostic_center {
	private String centerId;
	private String centerName;
	private long contact_no;
	private String address;

	public Diagnostic_center() {
	
	}

	public Diagnostic_center(String centerName, long contact_no, String address) {
		this.centerName = centerName;
		this.contact_no = contact_no;
		this.address = address;
	}
	
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

}
