package com.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.beans.ExceptionResponse;

@Component
public class ResponseUtil {
	
	public ResponseEntity<ExceptionResponse> buildErrorResponseEntity(ExceptionResponse exceptionResponse, HttpStatus httpStatus) {
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, httpStatus);	
	}
}
