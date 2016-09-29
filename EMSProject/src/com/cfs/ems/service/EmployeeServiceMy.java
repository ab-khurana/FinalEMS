package com.cfs.ems.service;
import javax.servlet.http.HttpServletRequest;


/**
 * @author vinamhat
 *
 */
public interface EmployeeServiceMy {
	//return type is boolean
	/**
	 * @param request
	 * @return boolean
	 * @throws Exception
	 */
	public Boolean register(HttpServletRequest request) throws Exception;
	}

