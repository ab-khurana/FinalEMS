package com.cfs.ems.service;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.dao.EmployeeDaoImplMy;


/**
 * @author vinamhat
 *
 */
public class EmployeeServiceImplMy  implements EmployeeServiceMy{
	
	/** method register for creating a new object and calling create function on it
	 * @return boolean status to register function
	 * @param  request
	 * @see com.cfs.ems.service.EmployeeServiceMy#register(javax.servlet.http.HttpServletRequest)
	 * 
	 */
	@Override
	//return type of function is boolean
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
		String gender = request.getParameter("Gender");
		String status= request.getParameter("Status");
		
		String role = request.getParameter("Role");
		String designation = request.getParameter("designation");
		String skills= request.getParameter("Skills");
		String isAdmin= request.getParameter("IsAdmin");
		
		String isManager= request.getParameter("IsManager");
		
		
		
		//setting the values in employee object
		
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
		employee.setStatus(status);
		employee.setRole(role);
		employee.setSkills(skills);
		employee.setDesignation(designation);
		
		
        //creating a new object and calling create function on it
		EmployeeDaoImplMy employeeDaoMy = new EmployeeDaoImplMy();
		Boolean status1 = employeeDaoMy.create(employee);
		
		//returning boolean 
		return status1;
	}

	
	
	
	

}
