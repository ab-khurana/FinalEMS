package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.service.LoginInterface;
import com.cfs.ems.service.LoginService;

public class InsertProjectAllocationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		LoginInterface inf = new LoginService();
		boolean status = false;

		try {
			status = inf.projectAllocations(request);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (status) {
			RequestDispatcher rd = request
					.getRequestDispatcher("projectAllocation.jsp");
			rd.include(request, response);
			out.println("<html><body onload=\"alert('Project Allocated Successfully!')\"></body></html>");

		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("projectAllocation.jsp");
			rd.include(request, response);
			out.println("<html><body onload=\"alert('UnSuccessfull Allocation')\"></body></html>");
		}
	}
}
