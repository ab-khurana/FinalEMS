package com.cfs.ems.dao;
import java.util.*;

import com.cfs.ems.domain.Employee;
import java.sql.*;
import java.util.ArrayList;

import com.cfs.ems.domain.Employee;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class EmployeeDaoImpl implements EmployeeDao {

	
	public LinkedList<Employee> view(Employee e) throws Exception {
		
		
		
		   Connection conn = null;
		   Statement stmt = null;
		   
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS", "root", "root");
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT * from employee_details";
		     
		      //step:5
		      ResultSet rs = stmt.executeQuery(sql);
		      //Employee e =null;
		      System.out.print("connection established");
		      
		      LinkedList<Employee> list = new LinkedList<Employee>();
		      while (rs.next()) {

 
		        Employee em= new Employee();
		    	  // setting values from database in employee object
		        
		    	 
				em.setEmployeeId(rs.getString("Employee_ID"));
				em.setFirstName(rs.getString("First_Name"));
						     
	
				list.add(em);
				
		      } 
		      return list;
		  //  return list;
		      }

	}
		      

				
			

		      
		      
		   		      
		  

