package com.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beans.EmployeeResponseData;
import com.dao.RetrieveBusinessData;
import com.exception.EmployeeNotFoundException;
import com.exception.InvalidRequestDataException;

@Service
public class ServiceRequest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ServiceRequest.class);
	
	@Autowired
	private RetrieveBusinessData retrieveBusinessData;
	
	public EmployeeResponseData getEmployeeDetails(String empId)/* throws EmployeeNotFoundException,InvalidRequestDataException*/{
		int employeeId=0;
		
		if(StringUtils.isNumeric(empId)) {
			employeeId = Integer.parseInt(empId);
		}
		EmployeeResponseData employeeResponseData=null;
		
		if(!isValidEmployeeID(empId)) {
			LOGGER.info("invalid Request Data");
			throw new InvalidRequestDataException(empId);
		}else if(!isEmployeeExist(employeeId)) {
			LOGGER.info("Employee Id not found");
			throw new EmployeeNotFoundException(empId);
		}else{
			 employeeResponseData =retrieveBusinessData.retrieveEmployeeDetails(employeeId);	
		}
		return employeeResponseData;
	}
	
	private boolean isValidEmployeeID(String empId) {
		 return StringUtils.isNumeric(empId);
	}
	
	private boolean isEmployeeExist(int employeeId) {
		
		return employeeId==756560 ? true : false;
	}
}
