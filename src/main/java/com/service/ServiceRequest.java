package com.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beans.EmployeeResponseData;
import com.dao.RetrieveBusinessData;
import com.exception.EmployeeNotFoundException;

@Service
public class ServiceRequest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ServiceRequest.class);
	
	@Autowired
	private RetrieveBusinessData retrieveBusinessData;
	
	public EmployeeResponseData getEmployeeDetails(int empId) {
		EmployeeResponseData employeeResponseData=null;
		
		if(empId==756560) {
			 employeeResponseData =retrieveBusinessData.retrieveEmployeeDetails(empId);
		}else {
			try {
				throw new EmployeeNotFoundException(empId);
			} catch (EmployeeNotFoundException e) {
				LOGGER.info("Employee data not found for empId :"+empId);
			}
		}
		return employeeResponseData;
	}
}
