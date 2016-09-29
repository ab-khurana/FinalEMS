package com.cfs.ems.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cfs.ems.dao.*;
import com.cfs.ems.domain.*;
import com.cfs.ems.service.EmployeeViewService;
/*import com.cfs.ems.service.PersonalInformationService;*/

/**
 * @author Abhinav Chaudhary
 * Servlet implementation class PersonalInformationServlet
 * Serving the request to get personal details for a particular employee for employee view
 * take Employee id as input for request
 */
@WebServlet("/PersonalInformationServlet")
public class PersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	/** post method is called to get employee id as input for the request
	 * instantiate the employee view service class and calls the method getPersonalInformation to retrieve the information from database
	 * forward the request to PersonalInformation.jsp view
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 Employee employee =null;
		
		
		 EmployeeViewService employeeView = new  EmployeeViewService();
		 employee = employeeView.getPersonalInformation(request);
		 
		 /** sets the employee object to emp variable to be use in PersonalInformation.jsp view
		  * 
		  */
		 request.getSession().setAttribute("emp", employee);
		 
		RequestDispatcher rd = request.getRequestDispatcher("PersonalInformation.jsp");
		rd.forward(request, response);
			
		
	}

}
