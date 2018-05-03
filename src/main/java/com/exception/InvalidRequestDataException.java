package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestDataException extends RuntimeException{

	private static final long serialVersionUID = 1L;
//	private String message = "Invalid Employee Id in the request,  EmpId : ";

	public InvalidRequestDataException(String empId) {
		 super("Invalid Request Data , EmpId : "+ empId); 
	}
	
//	public InvalidRequestDataException(String empId) {
//		message = message + empId;
//	}
//	@Override
//	public String getMessage() {
//		// TODO Auto-generated method stub
//		return message;
//	}
}
