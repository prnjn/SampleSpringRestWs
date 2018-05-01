package com.exception;

public class EmployeeNotFoundException extends Exception{

	private String message = "Employee not found";

	public EmployeeNotFoundException() {
		// super(message); it takes only static variable
	}
	
	public EmployeeNotFoundException(int empId) {
		message = message+" for Employee : "+ Integer.toString(empId);
	}
	
	@Override
	public String toString() {
		return message;
	}
}
