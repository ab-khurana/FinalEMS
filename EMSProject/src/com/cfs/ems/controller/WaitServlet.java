package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WaitServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{	
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("ABC");
		
		String s=(String)request.getSession().getAttribute("Status1");
		
		System.out.println(s);
		
		out.println("Status " +s);
		
		
		
				
		/*
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		
		//Wait.time();
		
		
		
		/*try {
			Thread.sleep(3000);
			response.sendRedirect("project");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		//response.sendRedirect("project");
	}
	
	
	
}
