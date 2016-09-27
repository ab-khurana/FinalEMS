package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;
import com.cfs.ems.domain.ProjectDomain;

public class EditProjectDetails extends HttpServlet {
		
	
	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.out.println("In get");
	}*/
	
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		
		
		String projectid=request.getParameter("Dropdown");
		
		
		
		ProjectDomain p=null;
		try {
				p=new GetData().getData(projectid);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.println("<form action='UpdateProject' method='post'>");
        out.println("<center>");
        
        out.println("Project ID :<input type='text' value="+p.getProjectId()+" name=ProjectId>");
        out.println("<br><br><br>");
        
        
        out.println("Project Name :<input type='text' value="+p.getProjectName()+" name=ProjectName>");
        
       
        
        out.println("<br><br><br>");
        out.println("Satrt Date(YYYY-MM-DD Format Only) :<input type='date' value="+p.getStartDate()+" name=start_date>");
        
        out.println("<br><br><br>");
        out.println("End Date(YYYY-MM-DD Format Only) :<input type='date' value="+p.getEndDate()+" name=end_date>");
        
        out.println("<br><br><br>");
        out.println("Manager Id:    <select name='Dropdown'>" ); 
		List<String> l=null;
			try {
				l=new GetData().getData("employee_id", "employee_details");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<option selected>" +p.getManagerId()+"</option>");	
for(String a: l)
{
	
	if(a.equals(p.getManagerId()))
	{
		continue;
	}
	else
			out.println("<option>" +a+"</option>");
}
out.println("</select>");
        
        out.println("<br><br><br>");
       
       
		
        out.println("<br><br><br>");
        out.println("Client Id:    <select name='Dropdown1'>" ); 
		l=null;
			try {
				l=new GetData().getData("client_id", "client_details");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<option selected>" +p.getClientId()+"</option>");	
for(String a: l)
{
	
	if(a.equals(p.getClientId()))
	{
		continue;
	}
	else
			out.println("<option>" +a+"</option>");
}
out.println("</select>");
        
        out.println("<br><br><br>");
        
        out.println("Status:    <select name='Status'>" ); 
        l=null;
		try {
			l=new GetData().getData("status", "project_details" , "project_id", p.getProjectId());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<option selected>" +p.getStatus()+"</option>");
		System.out.println(1);
for(String a: l)
{

if(p.getStatus().equals("Active"))
{
	out.println("<option>InActive</option>");;
}
else
		out.println("<option>Active</option>");
}
out.println("</select>");
       
        
        out.println("<br><br><br>");
        out.println("Description :<input type='text' value="+p.getDescription()+" name=Description>");
        
        out.println("<br><br><br>");
        
        
        out.println("<br><br><br>");
        
        out.println("<input type='submit' value='submit'/>");
        out.println("</form>");
        
        
        
	
	}
}
