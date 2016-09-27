package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cfs.ems.dao.ListOfProjectsDatabase;
import com.cfs.ems.domain.ProjectAllocation;

public class ListOfProjectsServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		

		ListOfProjectsDatabase op = new ListOfProjectsDatabase();
		LinkedList<ProjectAllocation> linkedList = op.extractData(); 
		HttpSession session = req.getSession();
		session.setAttribute("employeeList", linkedList);
		resp.sendRedirect("listOfProjects.jsp");

		/*resp.setContentType("text/html");

		out.write("<table border='black' cellpadding = '5'>");
		out.write("<tr>");
		out.write("<th>Project Allocation ID</th>");
		out.write("<th>Project ID</th>");
		out.write("<th>Project Name</th>");
		out.write("<th>Employee ID</th>");
		//		out.write("<th>Employee Name</th>");
		out.write("<th>Designation</th>");
		out.write("<th>Start Date</th>");
		out.write("<th>End Date</th>");
		out.write("<th>Status</th>");
		out.write("</tr>");

		out.write("<script language='javascript'>function editRecord1(id){var f=document.form;f.method='post';	f.action='edit.jsp?id='+id;	f.submit();	}" +
				"function deleteRecord(id){var f=document.form;f.method='post';	f.action='deletes?id='+id;	f.submit();	}</script>");

		for(ProjectAllocation pa : linkedList){
			ServletContext scontext = req.getServletContext();
			scontext.setAttribute("pa_id", pa.getProjectAllId());
			out.write("</tr>");
			out.write("<td>"+pa.getProjectAllId()+"</td>");
			out.write("<td>"+pa.getProjectId()+"</td>");
			out.write("<td>"+pa.getProjectName()+"</td>");
			out.write("<td>"+pa.getEmployeeId()+"</td>");
			//			out.write("<td>"+pa.getEmployeeName()+"</td>");
			out.write("<td>"+pa.getDesignation()+"</td>");
			out.write("<td>"+pa.getStartDate()+"</td>");
			out.write("<td>"+pa.getEndDate()+"</td>");
			out.write("<td>"+pa.getStatus()+"</td>");
			out.write("<td> <input type = 'button' value ='EDIT'  onclick=editRecord1(pa.getProjectAllId());></td>");
			out.write("<td> <input type = 'button' value ='DELETE' onclick=deleteRecord(pa.getProjectAllId());></td> ");
			out.write("</tr>");
		}
*/
	}

}


