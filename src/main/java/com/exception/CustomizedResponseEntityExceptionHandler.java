package com.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.beans.ExceptionResponse;
import com.util.ResponseUtil;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

	@Autowired
	ResponseUtil responseUtil;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex , WebRequest  request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return responseUtil.buildErrorResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return responseUtil.buildErrorResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidRequestDataException.class)
	public final ResponseEntity<ExceptionResponse> invalidRequestDataException(InvalidRequestDataException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));		
		return responseUtil.buildErrorResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
