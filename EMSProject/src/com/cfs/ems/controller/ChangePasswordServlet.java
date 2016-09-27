package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.cfs.ems.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordServlet extends HttpServlet
{
	

	/*public void doGet(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException
	{
		doPost(req, res);
		
	}*/
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String oldPassword= req.getParameter("password");
		String newPassword= req.getParameter("newpassword");
		String confirmNewPassword= req.getParameter("confirmpassword");
		if(newPassword.equals(confirmNewPassword))
		{
		ChangePasswordDao changePassword = new ChangePasswordDao();
		try {
			int status = changePassword.changePassword(oldPassword,newPassword,req);
			if(status!=0)
			out.println("Password changed successfully");
			
			else
				out.println("enter the correct old password");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		}
		else
		{
			out.println("New Password and Confirm new Password doesnot match" );
		}
		
	}
}


