package com.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.beans.ExceptionResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex , WebRequest  request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<EmployeeNotFoundException> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request){
		EmployeeNotFoundException employeeNotFoundExceptionResponse = new EmployeeNotFoundException(ex.getMessage());
		return new ResponseEntity<EmployeeNotFoundException>(employeeNotFoundExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidRequestDataException.class)
	public final ResponseEntity<InvalidRequestDataException> invalidRequestDataException(InvalidRequestDataException ex, WebRequest request){
		InvalidRequestDataException invalidRequestDataExceptionResponse = new InvalidRequestDataException(ex.getMessage());
		return new ResponseEntity<InvalidRequestDataException>(invalidRequestDataExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	protected ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request){
//		//String bodyOfResponse= "This is the body of response which can be passed instead of bean object"
//		//ServiceErrorResponse serviceErrorResponse = new ServiceErrorResponse("Employee not Found for EmployeeIddd : "+ex.getMessage());
//		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//	}
	
//	 @ExceptionHandler(InvalidRequestDataException.class)
//	    public ResponseEntity<String> handleEntityNotFoundException(HttpServletRequest request, Exception ex) {
//	        return ResponseUtil.buildErrorResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
//	    }
}
