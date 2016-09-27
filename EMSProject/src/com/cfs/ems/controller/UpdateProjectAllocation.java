package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.service.LoginInterface;
import com.cfs.ems.service.LoginService;



public class UpdateProjectAllocation extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
boolean st=false;
		
		PrintWriter out = response.getWriter();  
	LoginInterface upe=new LoginService();
	
	try {
		st=upe.editProjectAllocation1(request);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Dan");
	if(st)
	{
	out.write(" Updated Successfully ");	
	}
	else{
		out.write("failed to update");
	}
	}

}
