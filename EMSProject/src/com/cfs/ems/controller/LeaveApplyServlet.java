package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cfs.ems.dao.LeaveDao;
import com.cfs.ems.domain.LeavePojo;
import com.cfs.ems.service.LeaveService;

public class LeaveApplyServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter out = response.getWriter();	
	response.setContentType("text/html");
	String empId = (String)request.getSession().getAttribute("empId");
	String startdateString = request.getParameter("start_date").toString();
	String enddateString = request.getParameter("end_date").toString();
	System.out.println("startdate: "+startdateString);
	System.out.println("enddate: "+enddateString);
	String reason = request.getParameter("reason");
	String managerId = request.getParameter("Manager_id");
	SimpleDateFormat Formatter= new SimpleDateFormat("yyyy-mm-dd");
	java.sql.Date startdate = null;
	java.sql.Date enddate = null;
	try {
		startdate = new java.sql.Date(Formatter.parse(startdateString).getTime());
		enddate = new java.sql.Date(Formatter.parse(enddateString).getTime());
	} catch (ParseException e1) {
		
		e1.printStackTrace();
	}
	LeavePojo leavePojo= new LeavePojo();
	LeaveService leaveService= new LeaveService();
	leavePojo.setEmployeeId(empId);
	leavePojo.setEndDate(enddate);
	leavePojo.setStartDate(startdate);
	leavePojo.setManagerId(managerId);
	leavePojo.setReason(reason);
	
	System.out.println("startdate: "+startdate);
	System.out.println("enddate: "+enddate);
	System.out.println("reason: "+reason);
	System.out.println("Manager_id: "+managerId);
	LeaveDao leaveDao = new LeaveDao();
	try {
		Boolean status = leaveService.applyLeaveService(leavePojo);
		if (status){
		out.print("applied for the leave");

		RequestDispatcher rd=request.getRequestDispatcher("/ManagerLeavePage.html");
		 rd.forward(request, response);
		
		}
		else{
			out.print("Not applied");

			RequestDispatcher rd=request.getRequestDispatcher("/ApplyLeavePage.html");
			 rd.forward(request, response);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	

}
}
