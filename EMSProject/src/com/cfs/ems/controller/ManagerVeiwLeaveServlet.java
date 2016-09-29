package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.LeaveDao;
import com.cfs.ems.domain.LeavePojo;
import com.cfs.ems.service.LeaveService;

public class ManagerVeiwLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		try {
			
		String empId  = (String)request.getSession().getAttribute("empId");
		System.out.println("servlet"+empId);
	
		LeaveService leaveService = new  LeaveService();
		List<LeavePojo> viewList= leaveService.LeaveListService(empId);
	
		out.print("<html>" +
				"<head> Leave Appiled by the employees till date </head>" +
				"<body>" +
				"<table border='black'>" +
				"<tr><th>emp_id</th>"+
				"<th>Leave_id</th>" +
				"<th>Start Date</th> " +
				"<th>End Date</th>"+
				"<th>Reason</th>" +
				"<th>Status</th>"+
				"<th>Submit<th>"+
				"</tr>");
		 for(LeavePojo lp : viewList){
		out.print("<tr>" +
					"<td>"+lp.getEmployeeId() +"</td>" +
					"<td>"+lp.getLeaveId() +"</td>" +
					"<td>"+lp.getStartDate()+"</td>"+
					"<td>"+lp.getEndDate()+"</td> " +
					"<td>"+lp.getReason() +"</td>" +
					"<td>"+lp.getStatus() +"</td>" +
				"<form action='updateview' method='post'><td>approved<input type='radio' name='"+lp.getLeaveId()+"' value='approved'/>" +
				"<br>reject<input type='radio' name='"+lp.getLeaveId()+"' value='reject'/></td>" +
				
				"<td><input type='submit' name='submit'/></td>" +
				"<input type='hidden' value='"+lp.getLeaveId()+"' name='leave_id' "+
				"</form>" +
				"</tr>");
		 }
		 out.print("to go to  leave view page <a href='ManagerLeavePage.html'>click</a>"+
				"</table></body></html>");
	
	
		 

} catch (Exception e) {
	e.printStackTrace();
	out.print("Exception occured... Please try again later...");
}		
}
}