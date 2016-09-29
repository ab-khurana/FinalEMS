package com.cfs.ems.controller;

//Get values from user and validate the same

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;

import com.cfs.ems.domain.ProjectDomain;

public class SearchProjectDeatilsServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		//Get values from user
		
		String projectId = request.getParameter("project_id");
		
		
		String projectName = request.getParameter("project_name");
		
		
		
		
		ProjectDomain p=null;
		
		//When no input is selected
		
		
		if((projectId=="")&&(projectName=="")){

			
				out.println(" Enter valid inputs ");
	
		}
		
		//If project name is null, print on basis of project id
		else{
		if(projectName=="")
		{
		
		try {
					p=new GetData().getData(projectId);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			}
		
		
		//If project id is null, print on basis of project name
		
		else
			if(projectId=="")
			{
				try {
					p=new GetData().getData(projectName, 1);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			}
		
		//if both project id and name is given, validate them and print details
		
			else
				if((projectId!=null)&&(projectName!=null)){
				try {
					p=new GetData().getData(projectId, projectName, 1);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				}
		
		//If input values doesn't match with database values, alert the user
				String s=p.getProjectId();
				String q=p.getProjectName();
				
				if(s==null||q==null)
				{	
						
					out.println("No record found    -      ");
					out.println("Input mismatch: Check your inputs");
					
				}
		
				
		
	
				
				//Print project details in browser
		
				else
				{
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
					
					
						out.println("<tr>");
						out.println("<td>"+p.getProjectId()+"</td>");
						out.println("<td>"+p.getProjectName()+"</td>");
						out.println("<td>"+p.getStartDate()+"</td>");
						out.println("<td>"+p.getEndDate()+"</td>");
						out.println("<td>"+p.getClientId()+"</td>");
						out.println("<td>"+p.getManagerName()+"</td>");
						out.println("<td>"+p.getManagerId()+"</td>");
						out.println("<td>"+p.getStatus()+"</td>");
						out.println("<td>"+p.getDescription()+"</td>");
						out.println("</tr>");
					
					out.println("</table>");
					
		
				}	
		}
	}
}

