package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordDao {

	public int changePassword(String old, String newPassword, HttpServletRequest req) throws ClassNotFoundException, SQLException
	{   
		
		String empId= (String)req.getSession().getAttribute("empId");
		String sql= "select employee_password from login_table where employee_id =?";
		String sql2 = "update login_table set employee_password =? where employee_id=?";
		
		CreateConnection create = new CreateConnection();
		Connection connection= create.createConnection();
		System.out.println("returned");
				
		PreparedStatement prepared = connection.prepareStatement(sql);
		
		System.out.println(empId);
		prepared.setString(1,empId);
		
		
		
		ResultSet rs = prepared.executeQuery();
		System.out.println(rs);
		rs.first();
		
		
		String getPassword = rs.getString("employee_password");
		System.out.println("Password form database" +getPassword);
		System.out.println(old);
		//System.out.println(getPassword);
		if(getPassword.equals(old))
		
		{    System.out.println("verified");
			 prepared = connection.prepareStatement(sql2);
			 prepared.setString(1, newPassword);
				prepared.setString(2,empId);
			 int status =  prepared.executeUpdate(); 
			return status;
		}
		
		else
			return 0;
		
	}
	
	
}

