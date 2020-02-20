package com.cpg.sprint1.dao;

import java.util.List;

import com.cpg.sprint1.entities.Test;

public interface ITestDao {
	public String addTest(Test test);
	public boolean removeTest(String testId);
	public List<Test> testList(String center_id);

}