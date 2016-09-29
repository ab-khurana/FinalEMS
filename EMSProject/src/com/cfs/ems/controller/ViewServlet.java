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


//taking request and showing result in servlet
public class ViewServlet extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<h1>  Welcome To View Page!!!</h1>");
		
        //creating object of EmployeeServiceImpl of service class 
		EmployeeServiceImpl emp = new EmployeeServiceImpl();
 
		//exception handling
		try {
			
           //creating table 
	        out.print("<tr> ");

			out.print("<table border=2>");
			out.print("<tr>");
			out.print("<th>EMPLOYEE_ID</th>");
			out.print("<th>EMPLOYEE_NAME</th>");
			out.print("<th>DETAILS</th>");

			out.print("<th>DELETE</th>");

			out.print("</tr>");
			
			//list iterator for showing list of objects from database
			//caliing view function defined in EmployeeDaoImpl
			LinkedList<Employee> employeeList = emp.view(request, response);
			Iterator<Employee> iter = employeeList.iterator();
			
			while (iter.hasNext()) {
				
			out.print("<tr>");

			Employee e = iter.next();
			
			// showing id and name from object of service class
			
			String Employee_ID = e.getEmployeeId();
			out.print("<td>" + e.getEmployeeId() + "</td>");
			out.print("<td>" + e.getFirstName() + "</td>");
			
			
            //button of details passing value to SearchServlet
			out.print("<td><form action='search'><input type='hidden' name='id' value='"+e.getEmployeeId() +"'>" +
						"<input type='submit' value ='Details'></form></td>");
			//button of details passing value to DelatehServlet
		    out.print("<td><form action='delete'><input type='hidden' name='Employee_ID' value='"+ e.getEmployeeId() +"'>" +
						"<input type='submit' value ='Delete'></form></td>");
				

			out.print("</tr>");

			}
			out.print("</table>");

		    } 
		   catch (Exception e) {

			e.printStackTrace();
		   }
		
	       }
         }
