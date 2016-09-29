package com.cfs.ems.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.DeleteDao;


public class DeleteServlet extends HttpServlet {

	//Servlet taking request and showing response on delete servlet
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		//taking parameter from form
		String Employee_ID= req.getParameter("Employee_ID");
		
	    // obj of DeleteDao class
		DeleteDao delete= new DeleteDao();
		
		//exception handling
		try {
			
		//calling function from service class	
			
		int number=	delete.deleteEmployee(Employee_ID);
		//printing output on servlet
		out.println("Employee status updated");
		out.write("<html><body><a href='view.html'>click</a></body></html>"); 
		
		} catch (ClassNotFoundException e) {


			e.getMessage();
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
		
		
	}
	
	 
	

}
 