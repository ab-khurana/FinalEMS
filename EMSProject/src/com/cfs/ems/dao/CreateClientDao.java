package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cfs.ems.domain.ClientDomain;
import com.cfs.ems.domain.ProjectDomain;

public class CreateClientDao {
	
	
	
public int insertIntoDatabase(ClientDomain c) throws ClassNotFoundException, SQLException
{
	
	
	
	CreateConnection create= new CreateConnection();
	Connection connection=create.createConnection();
	
	String sql = "insert into client_details values (?,?,?)";
	PreparedStatement p1 = connection.prepareStatement(sql);
	p1.setString(1, c.getClientId());
	p1.setString(2, c.getClientName());
	p1.setString(3, c.getDescription());
	

	int status = p1.executeUpdate();
	
	
	
	return status;
	
}
	

}
