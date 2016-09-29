package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 
/**
 * @author aadsharm
 *
 */
public class DeleteDao {

	
	public int deleteEmployee(String Employee_ID) throws ClassNotFoundException, SQLException
	   {
	
		//establishing connection with database
		CreateConnection create= new CreateConnection();
		Connection connection= create.createConnection();
		
		//updating status in database
		String sql="update employee_details set status='inactive' where Employee_ID= '"+Employee_ID+"'";
		
		PreparedStatement prepared = connection.prepareStatement(sql);
		
		//returning result to deleteEmployeefunction
		int number= prepared.executeUpdate();
		
		
		return number;
		
		
		
		
		
	}
	
	
	

	
}
 