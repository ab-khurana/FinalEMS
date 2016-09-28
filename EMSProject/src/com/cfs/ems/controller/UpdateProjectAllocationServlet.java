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

public class UpdateProjectAllocationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean status = false;

		PrintWriter out = response.getWriter();
		LoginInterface upe = new LoginService();

		try {
			status = upe.editProjectAllocation1(request);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (status) {
			/*RequestDispatcher rd = request
					.getRequestDispatcher("/updateprojectAllocation");
			rd.include(request, response);
			out.println("<html><body onload=\"alert('Data Updated Successfully')\"></body></html>");*/
			out.println("yess");
			
		} else {

			/*RequestDispatcher rd = request
					.getRequestDispatcher("listOfProjects.jsp");
			rd.include(request, response);
			out.println("<html><body onload=\"alert('Data Not Updated')\"></body></html>");*/
			
			out.println("noo");
		}
	}

}
