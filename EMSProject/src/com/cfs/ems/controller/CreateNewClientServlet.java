package com.cfs.ems.controller;
//team 2
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewClientServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		
		out.println("<form action='ClientInputDetails' method='post'>" +
				"Client  Id: <input type='text' name ='ClientId' value='' required>" + 
				"<br><br>" +
				"Client Name: <input type='text' name ='ClientName' value='' required>	" +
				"<br><br>"+
				
				"Description: <input type='text' name ='Description' value='' required>" +
				
					"<br><br>" +
					"<input type='submit' value='Submit'> </form>");
		
		response.sendRedirect("CreateProject");
					
		
	}

}
