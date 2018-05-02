package com.exception;

public class EmployeeNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Data not found for Employee Id : ";

	public EmployeeNotFoundException() {
		// super(message); it takes only static variable
	}
	
	public EmployeeNotFoundException(String empId) {
		message = message + empId;
	}

	@Override
	public String getMessage() {
		return message;
		
	}
}
