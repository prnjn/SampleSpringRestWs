package com.beans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.service.Cache;

@Component
public class EmployeeResponseData {

	private int employeeId;
	private String name;
	private String department;
	private ArrayList<String> skills; 

	@Autowired
	private Cache cache;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		if(null==cache) {
			System.out.println("cache is null");
		}
		
		if(null!=cache && !cache.getAltNameMap().isEmpty()) {
			System.out.println("cache is not null");
			return cache.getAltNameMap().get(this.employeeId);
		}else {
			return name;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}	
}
