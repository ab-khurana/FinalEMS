package com.cfs.ems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.CreateProjectDao;
import com.cfs.ems.dao.GetData;
import com.cfs.ems.domain.ProjectDomain;

public class ProjectDeatilsInput extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String project_id =request.getParameter("ProjectId");
		String project_name = request.getParameter("ProjectName");
		String start_date = request.getParameter("start_date").toString();
		String end_date = request.getParameter("end_date").toString();
		
		String manager_id = request.getParameter("Dropdown"); // YYYY-MM-DD
		String client_id = request.getParameter("Dropdown1");
		String status = request.getParameter("Status");
		String description = request.getParameter("Description");
		
		ProjectDomain project=new ProjectDomain();
	
		
		project.setProjectName(project_name);
		project.setProjectId(project_id);
		
		project.setManagerId(manager_id);
		List<String> l=null;
		try {
			l = new GetData().getData("first_name","employee_details", "employee_id", project.getManagerId());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
				
		String a1=(String)l.get(0);
		
		
		project.setManagerName(a1);
		
		
		project.setClientId(client_id);
		project.setStatus(status);
		project.setDescription(description);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date strtDate;
		try {
			strtDate = new java.sql.Date(formatter.parse(start_date).getTime());
			project.setStartDate(strtDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date endDate;
		try {
			endDate = new java.sql.Date(formatter1.parse(end_date).getTime());
			project.setEndDate(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(project.getStatus());
		int a=0;
		try {
			a = new CreateProjectDao().insertIntoDatabase(project);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("project");
		/*RequestDispatcher rd=request.getRequestDispatcher("/project");
		rd.forward(request, response);*/
		
	}

	
}
