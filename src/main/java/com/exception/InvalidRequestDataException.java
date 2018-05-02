package com.exception;

public class InvalidRequestDataException extends Exception{

	private static final long serialVersionUID = 1L;
	private String message = "Invalid Employee Id in the request,  EmpId : ";

	public InvalidRequestDataException() {
		// super(message); it takes only static variable
	}
	
	public InvalidRequestDataException(String empId) {
		message = message + empId;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
