package com.cfs.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cfs.ems.domain.LeavePojo;

public class LeaveDao {
	
	
	//Apply the leave in general;
	public Boolean applyLeaveDao(LeavePojo leavePojo) throws Exception {
		Boolean status = false;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		String sql = "insert into leave_table (startdate,enddate,reason,Manager_id,employee_id) values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1,leavePojo.getStartDate());
		ps.setDate(2,leavePojo.getEndDate());
		ps.setString(3,leavePojo.getReason());
		ps.setString(4,leavePojo.getManagerId());
		ps.setString(5,leavePojo.getEmployeeId());
		int result = ps.executeUpdate();
		System.out.println("No. of records successfully inserted: "+result);
		if(result>0) {status = true;} 
		else {status = false;}		
		return status;
	}
	
	
	
	//to view the leave list the employee have applied till date;
	public ResultSet viewapplyLeaveDao(String empId) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		Statement st1 = null;
		ResultSet rs = null;
		 st1 = con.createStatement();
		rs= st1.executeQuery("select * from leave_table where employee_id="+empId);
	     while(rs.next()){
				System.out.println(" emp_id "+rs.getString("employee_id")+" leave id" + rs.getInt("leave_id")+ "   start date "+rs.getDate("startdate")+
						" end date "+rs.getDate("enddate")+" reason " + rs.getString("reason")+"Status"+rs.getString("status")+"Manager_id"+rs.getString("Manager_id"));
		}
	     rs.beforeFirst();	
	 return rs;
	}
	
	
	
	
	//to view the manager the list of the applied leave by employees
	public ResultSet LeaveListDao(String empId) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("DAO1"+empId);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		Statement st1 = null;
		st1=con.createStatement();  
		ResultSet resultset = null;
		resultset= st1.executeQuery("select * from leave_table");
		System.out.println("DAO2"+empId);
		while(resultset.next())
			{
			System.out.println("DAO3"+empId);
			System.out.println(resultset.getString("Manager_id"));
		if(empId.equals((resultset.getString("Manager_id"))))
				{
			System.out.println("DAO4"+empId);
			resultset= st1.executeQuery("select * from leave_table where Manager_id='"+empId+"'AND status = 'pending'");
			while(resultset.next())
					{	
					System.out.println("applied emp_id "+resultset.getString("employee_id")+" leave id" + resultset.getInt("leave_id")+ 
					"start date "+resultset.getDate("startdate")+" end date "+resultset.getDate("enddate")+
					"reason " + resultset.getString("reason")+"Status"+resultset.getString("status")+
					"Manager_id"+resultset.getString("Manager_id"));}
		     }
			}
		resultset.beforeFirst();
		return resultset; }
		
	
	
	
	
	//update the status to approved or reject by the manager
	public Boolean updatedLeaveListDao(String updatedStatus, String leave_id) throws Exception {
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
	if(result>0) {status = true;}
	else {status = false;}		
	return status;
	}	
}
