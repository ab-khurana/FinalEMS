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
/**
 * @author vinamhat
 *
 */

public class RegisterServlet extends HttpServlet {
	
	/** Do Post method to serve the request of registering an employee
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 *@param request for request object
	 *@param response for response object
	 @throws IOException, ServletException
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		
		//object of EmployeeService 
		EmployeeServiceMy employeeService = null; 
		
		//exception handling
		try {
			employeeService = new EmployeeServiceImplMy();
			
		//calling register function from service class 
			Boolean status = employeeService.register(request);
			
		//checking status
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
