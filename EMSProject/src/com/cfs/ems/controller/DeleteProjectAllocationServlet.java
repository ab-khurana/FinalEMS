package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.service.*;

public class DeleteProjectAllocationServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		LoginService employeeService = null; 
		String id=request.getParameter("id");
		
		try {
			employeeService = new LoginService();
			Boolean status = employeeService.deleteService(id);
			if(status) {
				response.sendRedirect("ListOfProjects");
			} else {
				response.sendRedirect("ListOfProjects");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("");
		}			
	
	}
}
