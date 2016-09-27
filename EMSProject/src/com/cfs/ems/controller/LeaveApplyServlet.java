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

public class LeaveApplyServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter out = response.getWriter();	
	response.setContentType("text/html");
	String emp_id = (String)request.getSession().getAttribute("empId");
	String startdateString = request.getParameter("start_date").toString();
	String enddateString = request.getParameter("end_date").toString();
	String reason = request.getParameter("reason");
	String manager_id = request.getParameter("manager_id");
	SimpleDateFormat Formatter= new SimpleDateFormat("yyyy-mm-dd");
	java.sql.Date startdate = null;
	java.sql.Date enddate = null;
	try {
		startdate = new java.sql.Date(Formatter.parse(startdateString).getTime());
		enddate = new java.sql.Date(Formatter.parse(enddateString).getTime());
	} catch (ParseException e1) {
		
		e1.printStackTrace();
	}
	
	System.out.println("startdate: "+startdate);
	System.out.println("enddate: "+enddate);
	System.out.println("reason: "+reason);
	System.out.println("manager_id: "+manager_id);
	LeaveDao leaveDao = new LeaveDao();
	try {
		Boolean status = leaveDao.applyLeave(startdate,enddate,reason,manager_id, emp_id);
		if (status){
		out.print("applied for the leave");
	
		}
		else{
			out.print("Not applied");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	

}
}
