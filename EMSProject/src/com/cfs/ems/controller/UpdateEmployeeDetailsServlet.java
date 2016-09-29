package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.service.UpdateEmployeeService;
import com.cfs.ems.service.UpdateEmployeeServiceImp;

/**
 * @author Valencia and Darshandeep
 *
 */
public class UpdateEmployeeDetailsServlet extends HttpServlet {
	/**
	 * Post method to update the Employee details
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request is the request object
	 * @param response is the response object
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		boolean st=false;
		
		PrintWriter out = response.getWriter();  
	UpdateEmployeeService upe=new UpdateEmployeeServiceImp();
	
	try {
		st=upe.editemployee(request);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Dan");
	

	if(st)
	{
	out.write("Employee detail is updated ");	
	out.write("<html><body><a href='view.html'>click</a></body></html>");
	}
	else{
		out.write("failed to update");
		out.write("<html><body><a href='view.html'>click</a></body></html>");
	}
	
	
   
	}
}


