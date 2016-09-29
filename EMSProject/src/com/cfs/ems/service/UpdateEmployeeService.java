package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.domain.Employee;

/**
 * @author Valencia and Darshandeep
 *
 */
public interface UpdateEmployeeService {
	/**
	 * @param request is request object
	 * @return Employee object
	 * @throws Exception
	 */
	public Employee update(HttpServletRequest request) throws Exception;
	/**
	 * @param request is request object
	 * @return boolean
	 * @throws Exception
	 */
	public boolean editemployee(HttpServletRequest request) throws Exception;	
	
}
 