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

/**
 * Servlet implementation class PersonalInformationServlet
 */
@WebServlet("/PersonalInformationServlet")
public class PersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Employee employee =null;
		
		String empId = (String)request.getSession().getAttribute("empId");
		AccessPersonalInformation information= new AccessPersonalInformation();
		//AccessAddress access = new AccessAddress();
		try {
			
		 employee=	information.retreiveInfo(empId);
		
		 request.getSession().setAttribute("emp", employee);
		
		 //response.getWriter().println(employee.getEmployeeId());
		
//		 address = access.retrieveAddress(empId);
		// request.getSession().setAttribute("add", address);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		//HttpSession session = request.getSession();
		
		// request.getSession().setAttribute("add",address);
		RequestDispatcher rd = request.getRequestDispatcher("PersonalInformation.jsp");
		rd.forward(request, response);
		
		
	}

}
