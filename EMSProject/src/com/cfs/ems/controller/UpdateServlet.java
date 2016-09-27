package com.cfs.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.domain.Employee;
import com.cfs.ems.service.UpdateEmployeeService;
import com.cfs.ems.service.UpdateEmployeeServiceImp;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType;




@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee e1 = new Employee();

		 
		PrintWriter out = response.getWriter();  
		UpdateEmployeeService sc = new UpdateEmployeeServiceImp();

		try {
			e1 = sc.update(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		response.getWriter().write("<html>");
		 response.getWriter().write("<form action=updateemployeedetails method=post>");
         response.getWriter().write("<center>");
         response.getWriter().write("Employee_Id (Do not change ):<input type='text' value="+e1.getEmployeeId()+" name=Employee_ID>");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("First_Name :<input type='text' value="+e1.getFirstName()+" name=First_Name>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Last_Name :<input type='text' value="+e1.getLastName()+" name=Last_Name>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("EmailId :<input type='text' value="+e1.getEmailId()+" name=Email_Id>");
         
          response.getWriter().write("<br><br><br>");
         response.getWriter().write("Address :<input type='text' value="+e1.getAddress()+" name=Address>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Designation :<input type='text' value="+e1.getDesignation()+" name=Designation>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Role :<input type='text' value="+e1.getRole()+" name=Role>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Status :<input type='text' value="+e1.getStatus()+" name=Status>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Salary :<input type='text' value="+e1.getSalary()+" name=Salary>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("BirthDate :<input type='text' value="+e1.getBirthDate()+" name=Birth_Date>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("JoiningDate :<input type='text' value="+e1.getJoiningDate()+" name=Joining_Date>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Skills :<input type='text' value="+e1.getSkills()+" name=Skills>");
         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Gender :<input type='text' value="+e1.getGender()+" name=Gender>");
         
         
         response.getWriter().write("<br><br><br>");
         
         
         response.getWriter().write("<br><br><br>");
         
         response.getWriter().write("<input type='submit' value='submit' </input>");
         response.getWriter().write("</form>");
         response.getWriter().write("<center>");
         response.getWriter().write("</html>");
		
         System.out.println(e1.getFirstName());
         
        
	}
	

	
}
