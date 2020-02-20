package com.cpg.sprint1.entities;

public class Test {
	private String testId;
	private String testName;
	private String center_id;
	
	public Test() {
	}
	public Test(String testName, String center_id) {
		this.testName = testName;
		this.center_id = center_id;
	}
	
	public String getCenter_id() {
		return center_id;
	}
	public void setCenter_id(String center_id) {
		this.center_id = center_id;
	}
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	

}
