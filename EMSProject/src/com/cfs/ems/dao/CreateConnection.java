package com.cfs.ems.dao;
import java.sql.*;

public class CreateConnection {
	
	
	public Connection createConnection() throws ClassNotFoundException, SQLException
	{   
		System.out.println("connecting");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("forname");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		System.out.println("connected");
		return connection;
		
	}
	

}
