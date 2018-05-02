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
	
	public EmployeeResponseData getEmployeeDetails(String empId) throws EmployeeNotFoundException,InvalidRequestDataException{
		EmployeeResponseData employeeResponseData=null;
		
		if(isValidEmployeeID(empId)) {
			 int employeeId = Integer.parseInt(empId);
			 employeeResponseData =retrieveBusinessData.retrieveEmployeeDetails(employeeId);
		}else {
				LOGGER.info("Invaid Employee Id in request : "+empId);
				throw new InvalidRequestDataException(empId);
		}
		return employeeResponseData;
	}
	
	private boolean isValidEmployeeID(String empId) {
		boolean isValidEmp = false;
		isValidEmp=StringUtils.isNumeric(empId);
		return isValidEmp;
	}
	
	
}
