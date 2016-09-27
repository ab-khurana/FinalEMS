package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Project extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{	
	
		doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN http://www.w3.org/TR/html4/loose.dt'>" +
"<html>" +
"<head>" +
"<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>" +
"<title>Project Management</title>" +
"</head>" +
"<body>");
		out.print("   ");
		
		out.print("<form action='CreateProject' method='post'>" +
				"<input type='submit' value='Create Project'>" +
				"</form>");
		out.print("   ");
		
		out.println("<form action='DeleteProject' method='post'>"  +
				"<input type='submit' value='Delete Project'>"   +
				"</form>");
		out.print("   ");
		out.print("<form action='EditProject' method='post'>"  +
				"<input type='submit' value='Edit Project'>"   +
				"</form>");
		
		
		
		
		
		out.print("<form action='SearchProject' method='post'>"  +
				"<input type='submit' value='Search Project'>"   +
				"</form>");
		out.println("<h3>List of Projects :</h3>");
		new PrintAll().doPost(request, response);
		
		out.println("</body>" +
				"</html>" );
		
	}
	
}
