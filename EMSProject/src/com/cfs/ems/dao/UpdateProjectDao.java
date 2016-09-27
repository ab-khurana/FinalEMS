package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cfs.ems.domain.ProjectDomain;



public class UpdateProjectDao {
	
	
public int updateIntoDatabase(ProjectDomain p) throws ClassNotFoundException, SQLException
{
	
	
	CreateConnection create= new CreateConnection();
	Connection connection=create.createConnection();
	
	
	PreparedStatement prepared = connection.prepareStatement("update project_details set start_date=? , end_date=?," +
															"manager_name=?,manager_id=?,status=?,description=?, project_name=?, client_id=? where project_id=?");
	prepared.setString(9, p.getProjectId());
	prepared.setString(7, p.getProjectName());
	prepared.setDate(1, p.getStartDate());
	prepared.setDate(2, p.getEndDate());
	prepared.setString(3, p.getManagerName());
	prepared.setString(4, p.getManagerId());
	prepared.setString(8, p.getClientId());
	prepared.setString(5, p.getStatus());
	prepared.setString(6, p.getDescription());
	int status = prepared.executeUpdate();
	
	return status;
	
	
}

}
