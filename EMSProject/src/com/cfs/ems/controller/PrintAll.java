package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.cfs.ems.dao.GetData;
import com.cfs.ems.domain.ProjectDomain;

public class PrintAll extends HttpServlet {

 static final long serialVersionUID = 1L;
 
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<ProjectDomain> list=null;
		try {
				list = new GetData().getData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.println("<table border='black' border-width='5'>");
		out.println("<tr>");
		out.println("<th>ProjectId</th>");
		out.println("<th>Projectname</th>");
		out.println("<th>Start Date</th>");
		out.println("<th>End Date</th>");
		out.println("<th>Client Id</th>");
		out.println("<th>Manager Name</th>");
		out.println("<th>Manager Id</th>");
		out.println("<th>Status</th>");
		out.println("<th>Description</th>");
		out.println("</tr>");
		for (ProjectDomain l : list) {  
				
			out.println("<tr>");
			out.println("<td>"+l.getProjectId()+"</td>");
			out.println("<td>"+l.getProjectName()+"</td>");
			out.println("<td>"+l.getStartDate()+"</td>");
			out.println("<td>"+l.getEndDate()+"</td>");
			out.println("<td>"+l.getClientId()+"</td>");
			out.println("<td>"+l.getManagerName()+"</td>");
			out.println("<td>"+l.getManagerId()+"</td>");
			out.println("<td>"+l.getStatus()+"</td>");
			out.println("<td>"+l.getDescription()+"</td>");
			out.println("<form action='EditProjectDetails' method=post>");
			out.println("<td><input type='submit' value='Edit' name='Edit'></td>");
			out.println("<input type='hidden' value="+l.getProjectId()+" name='Dropdown'>");
			out.println("</form>");
			out.println("<form action='deleteProject' method=post>");
			out.println("<td><input type='submit' value='Delete'></td>");
			out.println("<input type='hidden' value="+l.getProjectId()+" name='pId'>");
			out.println("</form>");
			out.println("</tr>");
			
			
		}
		out.println("</table>");
		
		
	}

}
