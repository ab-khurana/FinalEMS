package com.cfs.ems.service;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.dao.EmployeeDaoImplMy;


public class EmployeeServiceImplMy  implements EmployeeServiceMy{
	
	@Override
	public Boolean register(HttpServletRequest request) throws Exception {
		
		// Receiving user input 
		Integer employeeId= Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailID");
		String mobileNo = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		Integer salary = Integer.parseInt(request.getParameter("salary")); // YYYY-MM-DD
		String birthDateString= request.getParameter("birthDate").toString();
		String joiningDateString= request.getParameter("joiningDate").toString();
		//Date joiningDate= request.getParameter("joiningDate");
		String gender = request.getParameter("gender");
		String status= request.getParameter("status");
		
		String role = request.getParameter("role");
		String designation = request.getParameter("designation");
		String skills= request.getParameter("skills");
		String isAdmin= request.getParameter("isAdmin");
		
		String isManager= request.getParameter("isManager");
		
		
		System.out.println("employeeId: "+employeeId);
		System.out.println("firstName: "+firstName);
		System.out.println("lastName: "+lastName);
		System.out.println("emailID: "+emailId);
		System.out.println("mobileNo: "+mobileNo);
		System.out.println("salary: "+salary);
		//System.out.println("birthDate: "+birthDate);
		System.out.println("address: "+address);
		//System.out.println("joiningDate: "+joiningDate);
		System.out.println("gender: "+gender);
		System.out.println("status: "+status);
		System.out.println("role: "+role);
		System.out.println("designation: "+designation);
		System.out.println("skills: "+skills);
		System.out.println("isAdmin: "+isAdmin);
		System.out.println("isManager: "+isManager);
		
		
		
		EmployeeMy employee = new EmployeeMy();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmailID(emailId);
		employee.setMobileNo(mobileNo);
		employee.setAddress(address);
		employee.setSalary(salary);
		employee.setGender(gender);
		employee.setIsAdmin(isAdmin);
		employee.setIsManager(isManager);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date birthDate = new java.sql.Date(formatter.parse(birthDateString).getTime());
		employee.setBirthDate(birthDate);
		
		
		SimpleDateFormat formatters = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date joiningDate = new java.sql.Date(formatter.parse(joiningDateString).getTime());
		employee.setJoiningDate(joiningDate);
		
		
		
		
		//employee.setJoiningDate(new Date());
		employee.setStatus(status);
		employee.setRole(role);
		employee.setSkills(skills);
		employee.setDesignation(designation);
		
		
		
		

		EmployeeDaoImplMy employeeDaoMy = new EmployeeDaoImplMy();
		Boolean status1 = employeeDaoMy.create(employee);
		
		return status1;
	}

	
	
	
	

}
