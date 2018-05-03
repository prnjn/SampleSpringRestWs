package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//private String message = "Data not found for Employee Id : ";

	public EmployeeNotFoundException(String empId) {
		 super("Employee not found for Employee Id : "+empId);
	}
	
//	public EmployeeNotFoundException(String empId) {
//		message = message + empId;
//	}
//
//	@Override
//	public String getMessage() {
//		return message;
//		
//	}
}
