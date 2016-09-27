package com.cfs.ems.dao;
import java.sql.*;

import com.cfs.ems.service.EmployeeMy;




	public class EmployeeDaoImplMy implements EmployeeDaoMy {

		@Override
		public Boolean create(EmployeeMy e) throws Exception {
			
			Boolean status = false;
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			
			String sql = "insert into employee_details (Employee_ID,First_Name, Last_Name, Gender,BirthDate,JoiningDate, Phonenumber,EmailID, Address, Salary, Designation,Role,Status,Skills,IsAdmin,IsManager) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, e.getEmployeeId());
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setString(8, e.getEmailID());
			ps.setString(7, e.getMobileNo());
			ps.setString(9, e.getAddress());
			ps.setInt(10, e.getSalary());
			//java.sql.Date dt = new Date(Integer.parseInt(e.getBirthDate().split("-")[0]),Integer.parseInt(e.getBirthDate().split("-")[1]),Integer.parseInt(e.getBirthDate().split("-")[2]));
			//ps.setDate(7, dt);
			//java.sql.Date dt2 = new Date(new java.util.Date().getTime());
			//ps.setDate(8, dt2);
			ps.setString(13, e.getStatus());
			ps.setString(4, e.getGender());
			ps.setString(14, e.getSkills());
			ps.setString(12, e.getRole());
			ps.setString(11, e.getDesignation());
			ps.setDate(5, e.getBirthDate());
			ps.setDate(6, e.getJoiningDate());
			
			ps.setString(15,e.getIsAdmin());
			ps.setString(16, e.getIsManager());
			int result = ps.executeUpdate();
			
			System.out.println("No. of records successfully inserted: "+result);
			
			
			String username,password;
			char fnc = e.getFirstName().charAt(0);
			String fn = Character.toString(fnc);
			username=(String)fn.concat(e.getLastName());
			
			sql="insert into login_table(Employee_Id, employee_password, employee_username, isAdmin ) values(?,?,?,?)";
			System.out.println(sql);
			PreparedStatement ps1 = con.prepareStatement(sql);
			System.out.println(e.getEmployeeId());
			ps1.setInt(1, e.getEmployeeId());
			ps1.setString(2, "12345");
			ps1.setString(3, username);
			ps1.setString(4,e.getIsAdmin());
			
			int result1=ps1.executeUpdate();
			
			if(result>0) {
				status = true;
			} else {
				status = false;
			}		
			return status;
		}

		
		}
	
	


