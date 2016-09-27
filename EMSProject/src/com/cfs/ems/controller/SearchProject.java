package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;

public class SearchProject extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		
		out.println("<Form action='SearchProjectDeatils' method='post'>");
		out.println("Project Id:    <select name='project_id'>"); 
		List<String> l=null;
			try {
				l=new GetData().getData("project_id", "project_details");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("<option selected> </option>");
for(String a: l)
{
out.println("<option>" +a+"</option>");
}
out.println("</select>");

out.println("Project name:    <select name='project_name'>"); 
l=null;
	try {
		l=new GetData().getData("project_name", "project_details");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	out.println("<option selected> </option>");
for(String a: l)
{
out.println("<option>" +a+"</option>");
}
out.println("</select>");

out.println("<input type='submit' value='Submit'>");

out.print("</form>");
		
	
	}

}
