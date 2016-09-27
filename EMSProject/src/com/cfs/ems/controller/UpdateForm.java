package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.ListOfProjectsDatabase;
import com.cfs.ems.dao.ListOfProjectsInterface;
import com.cfs.ems.domain.ProjectAllocation;
import com.cfs.ems.service.LoginInterface;
import com.cfs.ems.service.LoginService;


public class UpdateForm extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		String id=request.getParameter("id");
		
		System.out.println(id);
		
		LoginInterface sc = new LoginService();
 
		ProjectAllocation e1=new ProjectAllocation();

		try {
			e1 = sc.editAllocate(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("a");
		 response.getWriter().write("<form action=updateprojectAllocation method=post>");
         response.getWriter().write("<center>");
         response.getWriter().write("Project Allocation Id (Do not change ):<input type='text' value="+e1.getProjectAllId()+" name='projectAllid'>");
         response.getWriter().write("<br><br><br>");
         
         ListOfProjectsInterface alldoa = new ListOfProjectsDatabase();
         List list=new ArrayList();
         list=alldoa.loguser();
         request.getSession().setAttribute("somename", list);
         
         
			java.util.List dataList = (List) request.getSession().getAttribute("somename");
			java.util.Iterator itr = dataList.iterator();
			
		
		
			 response.getWriter().write("Project name:<select name='projectname'>");
				
				while(itr.hasNext()) {
				String projectname=(String)itr.next();
				
				 response.getWriter().write("<option value="+projectname+">"+projectname+"</option>");
						
				 }
				response.getWriter().write("</select>");
        
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Employee Id :<input type='date' value="+e1.getEmployeeId()+" name='employeeId'>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Designation: <select name='designation'>" +
         		"<option value='designer'>Designer</option><option value='developer'>Developer</option>" +
         		"<option value='tester'>Tester</option><option value='Associate Consultant'>Associate Consultant</option>" +
         		"<option value='Consultant'>Consultant</option>" +
         		"<option value='Software Engineer'>Software Engineer</option></select>");
		
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Start Date :<input type='date' value="+e1.getStartDate()+" name='startdate'>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("End Date :<input type='date' value="+e1.getEndDate()+" name='enddate'>");
         
                 
         
         response.getWriter().write("<br><br><br>");
         
         response.getWriter().write("<input type='submit' value='submit' </input>");
         response.getWriter().write("</form>");
         response.getWriter().write("<center>");
		
      
         
        
	}

}
