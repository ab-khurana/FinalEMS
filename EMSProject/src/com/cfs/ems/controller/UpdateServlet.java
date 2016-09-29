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


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//object of employee class
		Employee e1 = new Employee();

		 
		PrintWriter out = response.getWriter();  
	 
		UpdateEmployeeService sc = new UpdateEmployeeServiceImp();

		try {
			//calling update function defined in UpdateDaoImpl class
			e1 = sc.update(request);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
        //printing values in form
		 response.getWriter().write("<html>");
		 response.getWriter().write("<form action=updateemployeedetails method=post>");
         response.getWriter().write("<center>");
         response.getWriter().write("Employee_Id (Do not change ):<input type='number'  min='0'    required value="+e1.getEmployeeId()+" name=Employee_ID    >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("First_Name :<input type='text' required value="+e1.getFirstName()+" name=First_Name    >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Last_Name :<input type='text'  value="+e1.getLastName()+" name=Last_Name    >");         
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("EmailId :<input type='email' pattern='[^ @]*@[^ @]*'  required value="+e1.getEmailId()+" name=Email_Id     >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Address :<input type='text' required value="+e1.getAddress()+" name=Address     >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Designation :<input type='text'  required value="+e1.getDesignation()+" name=Designation     >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Role :");
         response.getWriter().write("<select name='Role'>");
         response.getWriter().write ("<option value='Tester'>Tester</option>");
         response.getWriter().write ("<option value='Developer'>Developer</option>");
         response.getWriter().write ("<option value='Team Lead'>Team Lead</option>");
         response.getWriter().write ("<option value='Manager'>Manager</option>");
         response.getWriter().write ("</select>");
         response.getWriter().write("<br><br>");
         response.getWriter().write("Status :");
         response.getWriter().write("<select name='Status'>");
         response.getWriter().write("<option value='Active'>Active</option>");
         response.getWriter().write("<option value='Inactive'>Inactive</option>");
         response.getWriter().write("<option value='Terminated'>Terminated</option>");
         response.getWriter().write ("</select>");
	     response.getWriter().write("<br><br><br>");
         response.getWriter().write("Salary :<input type='number'  min='0' required value="+e1.getSalary()+" name=Salary       >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("BirthDate :<input type='date' min='1956-09-27' max='1995-09-27'   required value="+e1.getBirthDate()+" name=Birth_Date     >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("JoiningDate :<input type='text'  required value="+e1.getJoiningDate()+" name=Joining_Date      >");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Skills :");
         response.getWriter().write("<select name='Skills'>");
         response.getWriter().write("<option value='Java'>Java</option>");
         response.getWriter().write("<option value='.Net'>.Net</option>");
         response.getWriter().write("<option value='PHP'>PHP</option>");
         response.getWriter().write("<option value='Testing'>Testing</option>");
         response.getWriter().write("<option value='Android'>Android</option>");
         response.getWriter().write("</select>");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("Gender:");
         response.getWriter().write("<form><select name='Gender'>");
         response.getWriter().write("<option value='Male'>Male</option>");
         response.getWriter().write ("<option value='Female'>Female</option> ");
         response.getWriter().write ("</select>");
         response.getWriter().write("<br><br></form>   ");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("<br><br><br>");
         response.getWriter().write("<input type='submit' value='submit' </input>");
         response.getWriter().write("</form>");
         response.getWriter().write("<center>");
         response.getWriter().write("</html>");
		
         
         
        
	}
	

	
}
