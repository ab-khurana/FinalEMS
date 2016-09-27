/*package com.cfs.ems.dao;
import com.cfs.ems.domain.*;

import java.sql.*;

public class AccessAddress {

	public Address retrieveAddress(String empId) throws ClassNotFoundException, SQLException
	{
		Address address = new Address();
		Employee employee= new Employee();
		
		CreateConnection create = new CreateConnection();
		Connection connection= create.createConnection();
		
		PreparedStatement prepared= connection.prepareStatement("Select * from address where employee_id =?");
		prepared.setString(1, empId);
		ResultSet rs = prepared.executeQuery();
		
		while(rs.next())
		{
		String str = rs.getString(2);
		address.setAddressLine1(str);
		
		 str = rs.getString(3);
		 address.setAddressLine2(str);
		 
		 str= rs.getString(4);
		 address.setTown(str);
		 
		 str = rs.getString(5);
		 address.setCity(str);
		 
		 str = rs.getString(6);
		 address.setState(str);
		 
		 str = rs.getString(7);
		 address.setCountry(str);
		 
		 int post = rs.getInt(8);
		 address.setPostalCode(post);
		 
		}
		
		return address;
	}
	
	
}
*/