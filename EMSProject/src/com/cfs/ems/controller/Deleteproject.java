package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;

public class Deleteproject extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<form action='deleteProject' method='Post'>" +
					"<h4> Project ID:    <select name='pId'>"); 
		List<String> l=null;
			try {
				l=new GetData().getData("project_id", "project_details", "status", "Active");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
for(String a: l)
{
out.println("<option>" +a+"</option>");
}
out.println("</select>" +
						
					"<input type='submit' value='submit'>" +
					"</form>");				
		
	}

}
