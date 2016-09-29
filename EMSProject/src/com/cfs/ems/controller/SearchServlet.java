package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.cfs.ems.domain.Employee;
import com.cfs.ems.service.SearchService;
import com.cfs.ems.service.SearchServiceImp;

/**
 * @author Lakshit 
 * Servlet for getting the Employee details using Employee_ID
 */

@WebServlet(description = "Search", urlPatterns = { "/SearchServlet" })
public class SearchServlet extends HttpServlet {
	/**
	 * Get method to process the request 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * @param request is the request object
	 * @param response is the response object
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee e = new Employee();

		PrintWriter out = response.getWriter();
		SearchService sc = new SearchServiceImp();

		try {
			e = sc.search(request);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (e.getFirstName() != null) {

			out.print("<table border=2>");
			out.print("<tr>");
			out.print("<th>EmployeeId</th>");
			out.print("<th>Firstname</th>");
			out.print("<th>LastName</th>");
			out.print("<th>Designation</th>");
			out.print("<th>Role</th>");
			out.print("<th>Status</th>");

			out.print("</tr>");

			out.print("<td>" + e.getEmployeeId() + "</td>");
			out.print("<td>" + e.getFirstName() + "</td>");
			out.print("<td>" + e.getLastName() + "</td>");
			out.print("<td>" + e.getDesignation() + "</td>");
			out.print("<td>" + e.getRole() + "</td>");
			out.print("<td>" + e.getStatus() + "</td>");

			out.print("</tr>");

			out.print("</table>");
			out.write("<html><body><a href='view.html'>click</a></body></html>");

		} else {
			out.println("Record not found");

		}
	}
}
