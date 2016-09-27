package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.LeaveDao;

public class ManagerVeiwLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		LeaveDao leaveDao = null; 
		try {
			
			String emp_id = (String)request.getSession().getAttribute("empId");
			leaveDao = new LeaveDao();
		ResultSet resultset = leaveDao.LeaveList(emp_id);
		
		
	
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
	
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-mm-dd");
		while(resultset.next()){

			Date startdate = formatter.parse(resultset.getDate("startdate").toString());
			Date enddate = formatter.parse(resultset.getDate("enddate").toString());
		out.print("<tr>" +
				"<td>"+resultset.getString("employee_id") +"</td>" +
				"<td>"+resultset.getString("leave_id") +"</td>" +
				"<td>"+startdate.toString()+"</td>"+
				"<td>"+enddate.toString() +"</td> " +
				"<td>"+resultset.getString("reason") +"</td>" +
				"<form action='updateview' method='post'><td>approved<input type='radio' name='"+resultset.getString("leave_id")+"' value='approved'/>" +
				"<br>reject<input type='radio' name='"+resultset.getString("leave_id")+"' value='reject'/></td>" +
				
				"<td><input type='submit' name='submit'/></td>" +
				"<input type='hidden' value='"+resultset.getString("leave_id")+"' name='leave_id' "+
				"</form>" +
				"</tr>"+
				"</body></html>");
	
		}

} catch (Exception e) {
	e.printStackTrace();
	out.print("Exception occured... Please try again later...");
}		
}
}