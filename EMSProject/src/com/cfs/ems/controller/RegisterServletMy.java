package com.cfs.ems.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.service.EmployeeServiceImplMy;
import com.cfs.ems.service.EmployeeServiceMy;


/**
 * Servlet implementation class RegisterServletMy
 */
@WebServlet("/RegisterServletMy")
public class RegisterServletMy extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		System.out.println("in first");
		EmployeeServiceMy employeeService = null; 
		
		try {
			employeeService = new EmployeeServiceImplMy();
			Boolean status = employeeService.register(request);
			if(status) {
				out.print("Employee created successfully...!!!");
			} else {
				out.print("Failed to create employee...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("Exception occured... Please try again later...");
		}		
	}

}
