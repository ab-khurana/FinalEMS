package com.cfs.ems.dao;

import java.sql.*;

import org.eclipse.jdt.internal.compiler.batch.Main;



public class DeleteProjectDao {

	
	public int deleteProject(String pId) throws ClassNotFoundException, SQLException
	{
		
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		
		
		
		String sql="update project_details set status= inactive where project_id=" +pId;
		PreparedStatement prepared = connection.prepareStatement("update project_details set status='inactive' where project_id= ?");
		prepared.setString(1, pId);
		
		
		
		
		int number = prepared.executeUpdate();
		
		
		
		
		return number;
		
		
		
		
		
	
		
	}
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int number = new DeleteProjectDao().deleteProject("2");
	}*/
	
}