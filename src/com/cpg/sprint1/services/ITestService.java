package com.cpg.sprint1.services;

import java.util.List;

import com.cpg.sprint1.entities.Test;

public interface ITestService {
	public String addTest(Test test);
	public boolean removeTest(String testId);
	public List<Test> testList(String id);
}