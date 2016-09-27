package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LeaveDao {
	
	
	//to apply the leave
	public Boolean applyLeave(Date startdate,Date enddate, String reason,String manager_id,String emp_id) throws Exception {
		
		Boolean status = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		String sql = "insert into leave_table (startdate,enddate,reason,manager_id,employee_id) values (?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1,startdate);
		ps.setDate(2,enddate);
		ps.setString(3,reason);
		ps.setString(4,manager_id);
		ps.setString(5,emp_id);
		int result = ps.executeUpdate();
		System.out.println("No. of records successfully inserted: "+result);
		
		if(result>0) {
			status = true;
			
		} else {
			status = false;
		}		
		return status;
	}
	
	//view the leave applied till today
	public ResultSet viewapplyLeave(String emp_id) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		Statement st1 = null;
		ResultSet rs = null;
		
	 st1 = con.createStatement();
		rs= st1.executeQuery("select * from leave_table where employee_id="+emp_id);
	     while(rs.next()){
				System.out.println(" emp_id "+rs.getString("employee_id")+" leave id" + rs.getInt("leave_id")+ "   start date "+rs.getDate("startdate")+
						" end date "+rs.getDate("enddate")+" reason " + rs.getString("reason")+"Status"+rs.getString("status")+"manager_id"+rs.getString("manager_id"));
		}
	     rs.beforeFirst();	
	 return rs;
	}
	
	//to view the manager leave list
	public ResultSet LeaveList(String emp_id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		Statement st1 = null;
		ResultSet rs = null;
		st1=con.createStatement();  
		ResultSet rs1 = null;

		System.out.println(emp_id);
		rs= st1.executeQuery("select * from leave_table");
		while(rs.next())
			{
			System.out.println(rs.getString("manager_id"));
			
		if(emp_id.equals((rs.getString("manager_id"))))
				{	System.out.println("1");
			rs1= st1.executeQuery("select * from leave_table where manager_id='"+emp_id+"'AND status = 'pending'");
			System.out.println("2");
			
			while(rs1.next())
					{	
				
				System.out.println("applied emp_id "+rs1.getString("employee_id")+" leave id" + rs1.getInt("leave_id")+ 
							"   start date "+rs1.getDate("startdate")+" end date "+rs1.getDate("enddate")+
							" reason " + rs1.getString("reason")+"Status"+rs1.getString("status")+
							"manager_id"+rs1.getString("manager_id"));
				
					}
		     
			 
				}
		break;
			}
			
		
		rs1.beforeFirst();
		return rs1;}
	
	
	//to update the status approved and reject
	public Boolean updatedLeaveList(String updatedStatus,String leave_id) throws Exception {
		
	Boolean status = false;

	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
	String sql = "update  leave_table set status =? where leave_id = ?";

	PreparedStatement ps = con.prepareStatement(sql);
	//emp_id, leave_id
	ps.setString(1,updatedStatus);
	ps.setString(2,leave_id);
	int result = ps.executeUpdate();
	System.out.println("No. of records successfully inserted: "+result);

	if(result>0) {
		status = true;
		
	} else {
		status = false;
	}		
	return status;
	}	
}
