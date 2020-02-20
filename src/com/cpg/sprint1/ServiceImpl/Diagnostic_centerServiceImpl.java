package com.cpg.sprint1.ServiceImpl;

import java.util.List;

import com.cpg.sprint1.dao.IDiagnostic_centerDao;
import com.cpg.sprint1.entities.Diagnostic_center;
import com.cpg.sprint1.exceptions.CenterNotFoundException;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IDiagnostic_centerService;

public class Diagnostic_centerServiceImpl implements IDiagnostic_centerService{
	IDiagnostic_centerDao dao;
	
	public Diagnostic_centerServiceImpl(IDiagnostic_centerDao dao) {
		this.dao = dao;
	}	

	@Override
	public Diagnostic_center addCenter(Diagnostic_center dc) {
		if(dc==null)
			throw new NullArgumentException("Null arguments exception");
		if(dc.getCenterName().length()>=3){
			Double num= Math.random();
			String id=dc.getCenterName().substring(0,3)+num.toString().substring(2, 6);
			dc.setCenterId(id);
		}
		else 
			System.out.println("Name must be at least 3 characters long");
		return dao.addCenter(dc);
	}

	@Override
	public boolean removeCenter(String centerId) {
		if(centerId==null)
			throw new CenterNotFoundException("Center not found");
		return dao.removeCenter(centerId);
	}

	@Override
	public List<Diagnostic_center> centerList() {
		return dao.centerList();
	}
}