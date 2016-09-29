package com.cfs.ems.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import com.cfs.ems.dao.*;

import com.cfs.ems.service.EmployeeViewService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Asham Saud, Yogesh Palanivel
 * Servlet class takes request from client that contains
 * old password, new password & confirm password.
 * The class contains doPost method and other HTML content.
 *
 */
public class ChangePasswordServlet extends HttpServlet
{
	
	
	/** method implemented is doPost method is taking the request to change password in reference to a particular empid
     * 
     * @param request & response. It contains an instance of EmployeeViewService and method changePassword returning status  
     * @return Responds back to the client with the help of status returned
     * @throws ServletException
     * @throws IOException
     */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/**creating the instance of EmployeeViewService class
	        * and calling method employeeView to get status
	        */
		 EmployeeViewService employeeView= new  EmployeeViewService();
		int status = employeeView.changePasword(request);
		/** If and else statements that give output to the client based on status provided by 
		  *changePasword method above  
		  * 
		  */
		if(status==-1)
		{
			out.println("Password length insufficient");
			out.println("Click here to go back below");
			out.println("<script>function goBack() {window.history.back()}</script>");
			out.println("<button onclick='goBack()'>Go Back</button>");
			
		}
		else if(status==-2)
		{
			out.println("New Password and Confirm Password does not match");
			out.println("Click here to go back below");
			out.println("<script>function goBack() {window.history.back()}</script>");
			out.println("<button onclick='goBack()'>Go Back</button>");
			
		}
		else if(status==0)
		{
			out.println("Updation database failed");
			out.println("Click here to go back below");
			out.println("<script>function goBack() {window.history.back()}</script>");
			out.println("<button onclick='goBack()'>Go Back</button>");
		}
		else
		{
			out.println("Password changed successfully");
			out.println("Click here to go back to home page");
			out.println("<a href ='EmployeeHome.jsp'>HOME</a>");
		}	
		
	}
}


