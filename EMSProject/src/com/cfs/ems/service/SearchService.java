package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.domain.Employee;

/**
 * @author Lakshit
 *
 */

public interface SearchService {
	/**
	 * @param request is request object
	 * @return Employee object
	 * @throws Exception
	 */
	public Employee search (HttpServletRequest request) throws Exception;
}
