package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.EmployeeDaoImpl;
import com.cfs.ems.domain.Employee;
import com.cfs.ems.service.EmployeeService;
import com.cfs.ems.service.EmployeeServiceImpl;

public class viewservlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>  Welcome To View Page!!!</h1>");

		EmployeeServiceImpl emp = new EmployeeServiceImpl();

		try {

			out.print("<tr> ");

			out.print("<table border=2>");
			out.print("<tr>");
			out.print("<th>EMPLOYEE_ID</th>");
			out.print("<th>EMPLOYEE_NAME</th>");
			out.print("<th>DELETE</th>");

			out.print("</tr>");
			LinkedList<Employee> employeeList = emp.view(request, response);
			Iterator<Employee> iter = employeeList.iterator();
			while (iter.hasNext()) {
				// out.print("<table border=2>");
				out.print("<tr>");

				Employee e = iter.next();
				String Employee_ID = e.getEmployeeId();
				out.print("<td>" + e.getEmployeeId() + "</td>");
				out.print("<td>" + e.getFirstName() + "</td>");

				out.print("<td><form action='delete'><input type='hidden' name='Employee_ID' value='"
						+ e.getEmployeeId()
						+ "'>"
						+ "<input type='submit' value ='Delete'></form></td>");

				out.print("</tr>");

			}
			out.print("</table>");

			// out.println(employee.getFirst_Name());

		} catch (Exception e) {

			e.printStackTrace();
		}
		// RequestDispatcher rd=request.getRequestDispatcher("DeleteServlet");
		// rd.forward(request, response);

	}
}
