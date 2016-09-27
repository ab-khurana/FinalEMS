package com.cfs.ems.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.EmployeeDao;
import com.cfs.ems.dao.EmployeeDaoImpl;
import com.cfs.ems.domain.Employee;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class EmployeeServiceImpl implements EmployeeService{

	public LinkedList<Employee> view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		EmployeeDao employeeDao = new EmployeeDaoImpl();

		Employee e= new Employee();


		
		LinkedList<Employee> list = new LinkedList<>();
		list = employeeDao.view(e);
		Iterator<Employee> iter = list.iterator();

		


		return list;

	}



}






