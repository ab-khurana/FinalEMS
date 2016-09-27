package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.domain.Employee;



public interface SearchService {

	public Employee search (HttpServletRequest request) throws Exception;
}
