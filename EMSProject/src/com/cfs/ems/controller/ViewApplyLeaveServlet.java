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

public class ViewApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();	
		LeaveDao leaveDao = new LeaveDao();
		response.setContentType("text/html");
		String emp_id = (String)request.getSession().getAttribute("empId");
		try {
			ResultSet resultset = leaveDao.viewapplyLeave(emp_id);
			out.print("<html>" +
					"<head>Appiled Leave till date</head>" +
					"<body>" +
					"<table border='black'>" +
					"<tr><th>emp_id</th>"+
					"<th>Leave_id</th>" +
					"<th>Start Date('yyyy-mm-dd')</th> " +
					"<th>End Date('yyyy-mm-dd')</th>"+
					"<th>Reason</th>" +
					"<th>Status</th>"+
					"<th>manager_id</th></tr>");
			
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-mm-dd");
			
			while(resultset.next()){
				
				Date startdate = formatter.parse(resultset.getDate("startdate").toString());
				Date enddate = formatter.parse(resultset.getDate("enddate").toString());
			out.print("<tr>" +
					"<td>"+resultset.getString("employee_id") +"</td>" +
					"<td>"+resultset.getString("Leave_id") +"</td>" +
					"<td>"+startdate.toString()+"</td>"+
					"<td>"+enddate.toString() +"</td> " +
					"<td>"+resultset.getString("reason") +"</td>" +
					"<td>"+resultset.getString("status") +"</td>" +
					"<td>"+resultset.getString("manager_id") +"</td>" +
					"</tr>"+
					"</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
