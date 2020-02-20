package com.cpg.sprint1.dao;

import java.util.List;

import com.cpg.sprint1.entities.Diagnostic_center;

public interface IDiagnostic_centerDao {
	public Diagnostic_center addCenter(Diagnostic_center dc);
	public boolean removeCenter(String centerId);
	public List<Diagnostic_center> centerList();	
}