package com.cfs.ems.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cfs.ems.dao.*;
import com.cfs.ems.domain.*;

import com.cfs.ems.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		LoginService lservice = null;


		try {
			lservice = new LoginService();
			Status status = lservice.login(request);
			HttpSession session = request.getSession(true);	
//			int count = ListOfProjectsDatabase.NoRows(); 
			session.setAttribute("firstName", status.getEmpName());
			session.setAttribute("lastName", status.getEmpLastName());
			session.setAttribute("empId", status.getEmpId());
//			session.setAttribute("employeeCount", count);
			
			if(status.getStatus()==1){
				//					response.getWriter().write("Login Successful for "+status.getEmpName() + " " + status.getEmpLastName());
				response.sendRedirect("dashboard.jsp");
			}
			else if (status.getStatus()==2){
				//					response.sendRedirect("EmployeeHome.jsp");
				
				RequestDispatcher rd = request.getRequestDispatcher("ManagerHome.jsp");
				rd.forward(request, response);

			}
			else if (status.getStatus()==3){
				//					response.sendRedirect("EmployeeHome.jsp");
				
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeHome.jsp");
				rd.forward(request, response);

			}
			else
				response.sendRedirect("home.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
