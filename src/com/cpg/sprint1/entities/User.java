package com.cpg.sprint1.entities;

import java.util.List;

public class User {
	private String user_role;
	private String gender;
	private String userPassword;
	private String userName;
	private long contactNo;
	private String userRole;
	private String emailId;
	private int age;
	private String userId;
	
	private List<Diagnostic_center> centerList;
	
	public User(String userName,String emailId, String userPassword, long contactNo, 
			String gender, int age,String user_role) {
		this.user_role = user_role;
		this.gender = gender;
		this.age = age;
		this.userPassword = userPassword;
		this.userName = userName;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public User() {
		
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}