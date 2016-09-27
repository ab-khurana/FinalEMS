package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cfs.ems.domain.ProjectDomain;



public class CreateProjectDao {
	
	
public int insertIntoDatabase(ProjectDomain p) throws ClassNotFoundException, SQLException
{
	
	
	CreateConnection create= new CreateConnection();
	Connection connection=create.createConnection();
	
	String sql = "insert into project_details values (?,?,?,?,?,?,?,?,?)";
	PreparedStatement p1 = connection.prepareStatement(sql);
	p1.setString(1, p.getProjectId());
	p1.setString(2, p.getProjectName());
	p1.setDate(3, p.getStartDate());
	p1.setDate(4, p.getEndDate());
	p1.setString(5, p.getManagerName());
	p1.setString(6, p.getManagerId());
	p1.setString(7, p.getClientId());
	p1.setString(8, p.getStatus());
	p1.setString(9, p.getDescription());
	int status = p1.executeUpdate();
	System.out.println("No. of records successfully inserted: "+status);
	return status;
	
}

}
