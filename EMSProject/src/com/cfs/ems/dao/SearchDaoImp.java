package com.cfs.ems.dao;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

import com.cfs.ems.domain.Employee;

/**
 * @author Lakshit
 *
 */

public class SearchDaoImp implements SearchDao  {
	/**
	 * @param Employee_ID
	 * @return Employee object
	 * @throws Exception
	 */
	@Override
	public Employee search1 (Employee e) throws Exception {

		boolean resultStatus;
         System.out.println("connecting");
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS","root","root");
		System.out.println("connection");
		Statement st = c.createStatement();

		String id = (String) e.getEmployeeId();
		ResultSet rs = st.executeQuery("select * from employee_details where Employee_ID= "+ id + "");
		
		while (rs.next()) {

			String First_Name = rs.getString("First_Name");
			String Last_Name = rs.getString("Last_Name");
			String Designation = rs.getString("Designation");
			String Role = rs.getString("Role");
			String Status = rs.getString("Status");

			e.setFirstName(rs.getString("First_Name"));
			e.setLastName(rs.getString("Last_Name"));
			e.setDesignation(rs.getString("Designation"));
			e.setRole(rs.getString("Role"));
			e.setStatus(rs.getString("Status"));

		}

		c.close();

		return e;

	}

}
