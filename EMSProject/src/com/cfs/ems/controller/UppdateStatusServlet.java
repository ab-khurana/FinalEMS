package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.LeaveDao;

public class UppdateStatusServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		//String leave_id=(String)request.getServletContext().getAttribute("Leave_id");
		LeaveDao leaveDao = new LeaveDao();
		String leave_id=request.getParameter("leave_id");
		String radio=request.getParameter(leave_id);
	
		
		if(radio==null)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("/managerveiw");
			 rd.forward(request, response);
		}
		
		else{
		try {
			Boolean status = leaveDao.updatedLeaveList(radio,leave_id);
			if (status){
				out.println("updated");
				
				}
				else{
					out.print("Not updated");
				}}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/managerveiw");
		 rd.forward(request, response);
		}
		
}
	}
