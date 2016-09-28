package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.ListOfProjectsDatabase;
import com.cfs.ems.dao.ListOfProjectsInterface;
import com.cfs.ems.domain.ProjectAllocation;
import com.cfs.ems.service.LoginInterface;
import com.cfs.ems.service.LoginService;


public class UpdateFormServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//PrintWriter out = response.getWriter();
		ListOfProjectsInterface lpe = new ListOfProjectsDatabase();
		
		String id=request.getParameter("id");
		
		System.out.println(id);
		
		LoginInterface sc = new LoginService();
		
		ProjectAllocation e1=new ProjectAllocation();
		List<ProjectAllocation> list=new ArrayList<ProjectAllocation>();
		try {
			e1 = sc.editAllocate(id);
			list.add(e1);
			request.getSession().setAttribute("editProjectAllocation", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(e1.getProjectAllId());
		System.out.println(e1.getEmployeeId());
		ListOfProjectsInterface alldoa = new ListOfProjectsDatabase();
	    List list1=new ArrayList();
	    list1=alldoa.loguser();
	    request.getSession().setAttribute("projectName", list1);
	    
		RequestDispatcher rd = request.getRequestDispatcher("EditProjectAllocation.jsp");  
		rd.include(request, response);  
		}
      
         
        
	}


