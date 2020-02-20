package com.cpg.sprint1.ServiceImpl;

import java.util.List;

import com.cpg.sprint1.dao.ITestDao;
import com.cpg.sprint1.entities.Test;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.exceptions.TestNotFoundException;
import com.cpg.sprint1.services.ITestService;

public class TestServiceImpl implements ITestService {
	ITestDao dao;
	
	public TestServiceImpl(ITestDao dao) {
		this.dao = dao;
	}
	
	public TestServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addTest(Test test) {
		if (test == null)
			throw new NullArgumentException("Null arguments exception");
		if (test.getTestName().length() >= 3) {
			Double num = Math.random();
			String id = test.getTestName().substring(0, 3) + num.toString().substring(2, 6);
			test.setTestId(id);
		} else
			return "Invalid name";
		return dao.addTest(test);
	}
	
	@Override
	public boolean removeTest(String testId) {
		if (testId == null)
			throw new TestNotFoundException("Test not found");
		return dao.removeTest(testId);
	}

	@Override
	public List<Test> testList(String id) {
		return dao.testList(id);

	}

}