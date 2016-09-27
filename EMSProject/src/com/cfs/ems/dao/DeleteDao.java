package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteDao {

	
	public int deleteEmployee(String Employee_ID) throws ClassNotFoundException, SQLException
	{
		System.out.print("connection");
		
		CreateConnection create= new CreateConnection();
		Connection connection= create.createConnection();
		
		String sql="update employee_details set status='inactive' where Employee_ID= '"+Employee_ID+"'";
		PreparedStatement prepared = connection.prepareStatement(sql);
		System.out.print("connection");
		System.out.println("1");
		int number= prepared.executeUpdate();
		
		System.out.println("updated");
		return number;
		
		
		
		
		
	}
	
	
	

	
}
 