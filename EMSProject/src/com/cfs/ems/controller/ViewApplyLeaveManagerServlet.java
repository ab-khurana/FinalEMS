package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cfs.ems.domain.LeavePojo;
import com.cfs.ems.service.LeaveService;

public class ViewApplyLeaveManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				PrintWriter out = response.getWriter();	
				LeaveService leaveService = new LeaveService();
				LeavePojo leavePojo = new LeavePojo();
				response.setContentType("text/html");
				String empId  = (String)request.getSession().getAttribute("empId");
				try {
					List<LeavePojo> viewList = leaveService.viewapplyLeaveService(empId);
					
					out.print("<html>" +
							"<head>Appiled Leave till date</head>" +
							"<body>" +
							"<table border='black'>" +
							"<tr><th>emp_id</th>"+
							"<tr><th>Leave_id</th>" +
							"<th>Start Date</th> " +
							"<th>End Date</th>"+
							"<th>Reason</th>" +
							"<th>Status</th>"+
							"<th>Manager_id</th></tr>");
					 for(LeavePojo lp : viewList){
						 out.print("<tr>" +
							"<td>"+lp.getEmployeeId() +"</td>" +
							"<td>"+lp.getLeaveId() +"</td>" +
							"<td>"+lp.getStartDate()+"</td>"+
							"<td>"+lp.getEndDate()+"</td> " +
							"<td>"+lp.getReason() +"</td>" +
							"<td>"+lp.getStatus() +"</td>" +
							"<td>"+lp.getLeaveId() +"</td>" +
							"</tr>");
					 }
					 out.print("to go to  leave view page <a href='ManagerLeavePage.html'>click</a>"+
							"</table></body></html>");
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			}
		}
