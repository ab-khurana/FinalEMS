package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.domain.Employee;

public interface UpdateEmployeeService {

	public Employee update(HttpServletRequest request) throws Exception;
	
	public boolean editemployee(HttpServletRequest request) throws Exception;	
	
}
 