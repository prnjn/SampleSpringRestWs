package com.beans;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRequestData {
	private int EmpoyeeId;

	public int getEmpoyeeId() {
		return EmpoyeeId;
	}

	public void setEmpoyeeId(int empoyeeId) {
		EmpoyeeId = empoyeeId;
	}


}
