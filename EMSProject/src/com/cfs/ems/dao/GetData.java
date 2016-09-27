package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cfs.ems.controller.Project;
import com.cfs.ems.domain.ProjectDomain;


public class GetData {
	
	
	LinkedList<String> list = new LinkedList<String>();
	
	public List getData(String name, String tableName) throws ClassNotFoundException, SQLException
	{
		
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		Statement stmt = connection.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
		
		
			String sql="SELECT " +name +" from " +tableName;
			
		 ResultSet rs = stmt.executeQuery(sql);
		 
		 while (rs.next()) {

				
				list.add(rs.getString(1));
				

			}
		 
		 
		
		return list;
		
	}
	
	
	
	public List getData(String name, String tableName, String fieldname, String value) throws ClassNotFoundException, SQLException
	{
		
		
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		Statement stmt = connection.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
		
		
		
		
			String sql="SELECT " +name +" from " +tableName +" where " +fieldname +" = " +"'" +value +"'";
			
		 ResultSet rs = stmt.executeQuery(sql);
		 
		 while (rs.next()) {

				
				list.add(rs.getString(1));
				

			}
		 
		 
		
		return list;
		
	}
	
	public ProjectDomain getData(String pId) throws ClassNotFoundException, SQLException
	{	
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		
		Statement stmt=connection.createStatement();  
		
		ResultSet rs=stmt.executeQuery("select * FROM project_details WHERE  project_id="+pId+"");
		
		
		ProjectDomain p=new ProjectDomain();
		while (rs.next()) {
        	
            p.setProjectName(rs.getString("project_name"));
            p.setStartDate(rs.getDate("start_date"));
            p.setEndDate(rs.getDate("end_date"));
            p.setManagerName(rs.getString("manager_name"));
            p.setManagerId(rs.getString("manager_id"));
            p.setClientId(rs.getString("client_id"));
            p.setStatus(rs.getString("status"));
            p.setDescription(rs.getString("description"));
		
		}
		
		p.setProjectId(pId);
		
		
		return p;
		
	}
	
	public ProjectDomain getData(String pName, int i) throws ClassNotFoundException, SQLException
	{	
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		
		Statement stmt=connection.createStatement();  
		
		ResultSet rs=stmt.executeQuery("select * FROM project_details WHERE  project_name='"+pName+"'");
		
		
		ProjectDomain p=new ProjectDomain();
		while (rs.next()) {
			p.setProjectId(rs.getString("project_id"));
            p.setProjectName(rs.getString("project_name"));
            p.setStartDate(rs.getDate("start_date"));
            p.setEndDate(rs.getDate("end_date"));
            p.setManagerName(rs.getString("manager_name"));
            p.setManagerId(rs.getString("manager_id"));
            p.setClientId(rs.getString("client_id"));
            p.setStatus(rs.getString("status"));
            p.setDescription(rs.getString("description"));
		
		}
		
		
		
		
		return p;
		
	}
	
	public ProjectDomain getData(String pId, String pName, int i) throws ClassNotFoundException, SQLException
	{	
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		
		Statement stmt=connection.createStatement();  
		
		ResultSet rs=stmt.executeQuery("select * FROM project_details WHERE project_name='"+pName+"' AND project_id= "+pId );
		
		
		ProjectDomain p=new ProjectDomain();
		while (rs.next()) {
			p.setProjectId(rs.getString("project_id"));
            p.setProjectName(rs.getString("project_name"));
            p.setStartDate(rs.getDate("start_date"));
            p.setEndDate(rs.getDate("end_date"));
            p.setManagerName(rs.getString("manager_name"));
            p.setManagerId(rs.getString("manager_id"));
            p.setClientId(rs.getString("client_id"));
            p.setStatus(rs.getString("status"));
            p.setDescription(rs.getString("description"));
		
		}
		
		
		
		
		return p;
		
	}
	
	
	public List getData() throws ClassNotFoundException, SQLException
	{	
		CreateConnection create= new CreateConnection();
		Connection connection=create.createConnection();
		
		Statement stmt=connection.createStatement();  
		
		ResultSet rs=stmt.executeQuery("select * FROM project_details" );
		
		LinkedList<ProjectDomain> list1 = new LinkedList<ProjectDomain>();
		
		while (rs.next()) {
			
			ProjectDomain p=new ProjectDomain();
			p.setProjectId(rs.getString("project_id"));
            p.setProjectName(rs.getString("project_name"));
            p.setStartDate(rs.getDate("start_date"));
            p.setEndDate(rs.getDate("end_date"));
            p.setManagerName(rs.getString("manager_name"));
            p.setManagerId(rs.getString("manager_id"));
            p.setClientId(rs.getString("client_id"));
            p.setStatus(rs.getString("status"));
            p.setDescription(rs.getString("description"));
            
            list1.add(p);
		
		}
		
		
		
		
		return list1;
		
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		List<String> l = l=new GetData().getData("project_id", "project_details", "status", "Active");
			
			for(String a : l)
			{
				System.out.println(l.get(0));
			}
			
			
	}*/
	

}
