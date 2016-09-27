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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		
		String Employee_ID= req.getParameter("Employee_ID");
		System.out.println(Employee_ID);
		DeleteDao delete= new DeleteDao();
		try {
			System.out.println("in try");
		int number=	delete.deleteEmployee(Employee_ID);
		out.println(number+"employee status updated");
		} catch (ClassNotFoundException e) {
			System.out.println("error");
			e.getMessage();
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
		
		
	}
	
	 
	

}
 