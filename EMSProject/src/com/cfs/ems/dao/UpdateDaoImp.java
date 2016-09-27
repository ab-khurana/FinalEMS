package com.cfs.ems.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.cfs.ems.domain.Employee;
import com.cfs.ems.domain.Employee;
import com.mysql.jdbc.PreparedStatement;

public class UpdateDaoImp implements UpdateDao {

	@Override
	public Employee update1(Employee e) throws Exception {
		// TODO Auto-generated method stub


		Class.forName("com.mysql.jdbc.Driver");

		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","root");    
		Statement stmt=con1.createStatement();  
		System.out.println("connection");
        ResultSet rs=stmt.executeQuery("select * FROM employee_details WHERE Employee_ID ="+"'"+ e.getEmployeeId() +"'");


		Employee e1= new Employee();

		while (rs.next()) {
		
		e1.setEmployeeId(rs.getString("Employee_Id"));
		e1.setFirstName(rs.getString("First_Name"));
		e1.setLastName(rs.getString("Last_Name"));
		e1.setDesignation(rs.getString("Designation"));
		e1.setRole(rs.getString("Role"));
		e1.setEmailId(rs.getString("EmailId"));
		e1.setStatus(rs.getString("Status"));
		e1.setAddress(rs.getString("Address"));
		e1.setBirthDate(rs.getDate("BirthDate"));
		e1.setJoiningDate(rs.getDate("JoiningDate"));
		e1.setSalary(rs.getInt("Salary"));
		e1.setSkills(rs.getString("Skills"));
		e1.setGender(rs.getString("Gender"));
		
		System.out.println(e1.getFirstName());
		}
		
		con1.close();
		return e1;
		
	}
	




		@Override
		public boolean updateedit(Employee e1) throws Exception {
			
			
		boolean st=false;
			System.out.println(e1.getDesignation());
			
		Class.forName("com.mysql.jdbc.Driver");
			
		Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","root"); 
		
		System.out.println("Inside dao");
		
        PreparedStatement ps= (PreparedStatement) con2.prepareStatement("update employee_details set First_Name=?, Last_Name=?, EmailId=?, Address=?, Salary=?,Designation=?,Role=?,Status=?,Skills=?,Gender=?, BirthDate=?, JoiningDate=? where  Employee_ID=?");  
        ps.setString(1,e1.getEmployeeId()); 
       
		System.out.println("Inside dao");
		
        ps.setString(1,e1.getFirstName());  
        ps.setString(2,e1.getLastName());  
        ps.setString(3,e1.getEmailId()); 
        ps.setString(4,e1.getAddress()); 
        ps.setString(6,e1.getDesignation()); 
        ps.setString(7,e1.getRole()); 
        ps.setString(8,e1.getStatus()); 
       
        ps.setInt(5,e1.getSalary()); 
        ps.setDate(11,(Date) e1.getBirthDate()); 
        ps.setDate(12,(Date) e1.getJoiningDate());
        ps.setString(9,e1.getSkills()); 
        ps.setString(10,e1.getGender());
        ps.setString(13,e1.getEmployeeId());
       
        System.out.println(e1.getFirstName());
       
	    int r=ps.executeUpdate();
	    
	    System.out.println(r);
        if(r>0){
    	   st=true;
        }
        else {
    	   st=false;
        }
        con2.close();
		return st;
		

			
		}
  
	  
	  
	  
}		
		
	


