package com.cfs.ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.ListOfProjectsDatabase;
import com.cfs.ems.dao.ListOfProjectsInterface;





public class InsertProcess extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	ListOfProjectsInterface alldoa = new ListOfProjectsDatabase();
    List list=new ArrayList();
    list=alldoa.loguser();
    request.getSession().setAttribute("somename", list);
    
    List list1=new ArrayList();
    list1=alldoa.emplog();
    
    request.getSession().setAttribute("somename1", list1);
    
 RequestDispatcher rd = request.getRequestDispatcher("projectAllocation.jsp");
	rd.include(request, response);    
	}
}
