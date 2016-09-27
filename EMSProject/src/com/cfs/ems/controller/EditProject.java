package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;

public class EditProject extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.println("<Form action='EditProjectDetails' method='post'>");
		out.println("Project I:    <select name='Dropdown'>"); 
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
			for(String a: l)
			{
					out.println("<option>" +a+"</option>");
			}
					out.println("</select> " +
							"<input type='submit' value='Submit'>" +
							" </form>");
		
	}

}
