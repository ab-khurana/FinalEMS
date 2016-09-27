package com.cfs.ems.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.dao.UpdateDao;
import com.cfs.ems.dao.UpdateDaoImp;
import com.cfs.ems.domain.Employee;

public class UpdateEmployeeServiceImp implements UpdateEmployeeService {
	
	public Employee update (HttpServletRequest request) throws Exception {

		// Receiving user input

		String id = request.getParameter("id");

		

	Employee emp = new Employee();

	emp.setEmployeeId(id);

	UpdateDao doi = new UpdateDaoImp();
	Employee s = doi.update1 (emp);
	
	

		return s;
	}

	@Override
	public boolean editemployee(HttpServletRequest request)
			throws Exception {
		boolean st=false;
		
		System.out.println("lala");
		
		
		   String Employee_Id = request.getParameter("Employee_ID");
		   String First_Name = request.getParameter("First_Name");
		   String Last_Name = request.getParameter("Last_Name");
		   String Designation = request.getParameter("Designation");
		   String Role = request.getParameter("Role");
		   String Email_Id = request.getParameter("Email_Id");
		   String Status = request.getParameter("Status");
		   String Address = request.getParameter("Address");
		   String BirthDate1 = request.getParameter("Birth_Date").toString();
		   String JoiningDate1 = request.getParameter("Joining_Date").toString();
		   int Salary = Integer.parseInt(request.getParameter("Salary"));
		   String Skills = request.getParameter("Skills");
		   String Gender = request.getParameter("Gender");
		   
		   System.out.println(First_Name);
		  
			
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		  java.sql.Date Birth_Date=new java.sql.Date(sdf.parse(BirthDate1).getTime());
		  java.sql.Date Joining_Date=new java.sql.Date(sdf.parse(JoiningDate1).getTime());
		 
		    Employee e4 = new Employee();
		   
			
		    
			e4.setEmployeeId(Employee_Id);
			e4.setFirstName(First_Name);
			e4.setLastName(Last_Name);
			e4.setDesignation(Designation);
			e4.setRole(Role);
			e4.setEmailId(Email_Id);
			e4.setStatus(Status);
			e4.setAddress(Address);
			e4.setBirthDate(Birth_Date);
			e4.setJoiningDate(Joining_Date);
			e4.setSalary(Salary);
			e4.setSkills(Skills);
			e4.setGender(Gender);
			
			System.out.println("enter into dao");
			UpdateDao obj=new UpdateDaoImp();
			st=obj.updateedit(e4);
			
		
		return st;
	}


			
	

}
