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
import com.service.ServiceRequest;

@RestController
public class WebServiceController {
	
	@Autowired
    private ServiceRequest serviceRequest;
	
//	@RequestMapping(value="restws/getEmpDetails/{empId}",method=RequestMethod.GET)
//	//@ResponseBody   // not required since using @RestController
//	public EmployeeResponseData getEmployeeDetails(@PathVariable("empId") int empId) {
//		return serviceRequest.getEmployeeDetails(empId);
//	}
	
	@RequestMapping(value="restws/getEmpDetails/{empId}",method=RequestMethod.GET)
	//@ResponseBody   // not required since using @RestController
	public ResponseEntity<?> getEmployeeDetails(@PathVariable("empId") int empId) {
		
		EmployeeResponseData data = serviceRequest.getEmployeeDetails(empId);
		
		if(null != data) {
			return new ResponseEntity<EmployeeResponseData>(data,HttpStatus.OK);
		}
		
		ServiceErrorResponse errorResponse = new ServiceErrorResponse("Data not found for Employee Id :"+empId);
		return new ResponseEntity<ServiceErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
		
	}
	
}
