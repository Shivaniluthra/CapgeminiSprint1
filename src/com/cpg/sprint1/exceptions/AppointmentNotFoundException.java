package com.cpg.sprint1.exceptions;

public class AppointmentNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppointmentNotFoundException(String s){
		super(s);
	}

}
