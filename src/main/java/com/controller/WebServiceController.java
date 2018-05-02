package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.EmployeeResponseData;
import com.errorResponse.ServiceErrorResponse;
import com.exception.EmployeeNotFoundException;
import com.exception.InvalidRequestDataException;
import com.service.ServiceRequest;

@RestController
public class WebServiceController {
	
	@Autowired
    private ServiceRequest serviceRequest;
	
	@RequestMapping(value="restws/getEmpDetails/{empId}",method=RequestMethod.GET)
	//@ResponseBody   // not required since using @RestController
	public ResponseEntity<?> getEmployeeDetails(@PathVariable("empId") String empId) {
		
		EmployeeResponseData data;
		try {
			data = serviceRequest.getEmployeeDetails(empId);
			return new ResponseEntity<EmployeeResponseData>(data,HttpStatus.OK);
		} catch (EmployeeNotFoundException | InvalidRequestDataException e) {
			ServiceErrorResponse errorResponse = new ServiceErrorResponse(e.getMessage());
			//= new ServiceErrorResponse("Data not found for Employee Id :"+empId);
			return new ResponseEntity<ServiceErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
		}
	}
	
}
