package com.dao;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.EmployeeResponseData;

@Repository
public class RetrieveBusinessData {

	@Autowired
	private EmployeeResponseData employeeResponseData;
	
	public EmployeeResponseData retrieveEmployeeDetails(int empId) {
		
		// Suppose this Data is retrieved from database
		ArrayList<String> employeeSkills = (ArrayList<String>) Stream.of("Core Java"
				                                    					,"Restful web services"
				                                    					,"Spring Boot"
				                                    					,"PLSQL").collect(Collectors.toList());
		
		employeeResponseData.setEmployeeId(empId);
		employeeResponseData.setName("Priyanjan Kumar");
		employeeResponseData.setDepartment("ENGNE");
		employeeResponseData.setSkills(employeeSkills);
		
		return employeeResponseData;
	}
}
