package com.cfs.ems.service;


	import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.EmployeeDao;
import com.cfs.ems.domain.Employee;
	public interface EmployeeService {
		public LinkedList<Employee> view(HttpServletRequest request, HttpServletResponse response) throws Exception;

		
	}



