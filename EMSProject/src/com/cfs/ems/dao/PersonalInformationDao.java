package com.cfs.ems.dao;
import java.sql.*;
import com.cfs.ems.domain.*;

import java.util.Date;

/**
 * @author Abhinav Chaudhary
 * Dao class to retrieve the information from database
 * It will return Employee instance to the EmployeeViewService class
 *
 */
public class PersonalInformationDao {

    /** method implemented to retrieve information from database
     * 
     * @param empId is the employee id maintained in the current session 
     * @return Employee instance
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public Employee getInfo(String empId) throws ClassNotFoundException, SQLException
	{

		Employee employee= new Employee();
		
       /**creating the instance of create connection class
        * establish the connection with the database
        */
		CreateConnection create = new CreateConnection();
		Connection connection= create.createConnection();
		
		PreparedStatement prepared= connection.prepareStatement("Select * from employee_details where Employee_ID =?");
		prepared.setString(1, empId);
		ResultSet rs = prepared.executeQuery();

		while(rs.next())
		{
			String str = rs.getString("employee_id");
			employee.setEmployeeId(str);

			str= rs.getString("first_name");
			employee.setFirstName(str); 

			str=rs.getString("last_name");
			employee.setLastName(str);

			str=rs.getString("gender");
			employee.setGender(str);

			java.sql.Date date = (java.sql.Date)rs.getDate("birthdate");
			employee.setBirthDate(date);

			java.sql.Date date1 = (java.sql.Date)rs.getDate("joiningdate");

			employee.setJoiningDate(date1);	 

			str=rs.getString("phonenumber");
			employee.setMobileNo(str);

			str = rs.getString("emailid");
			employee.setEmailId(str);

			str = rs.getString("salary");
			employee.setSalary(Integer.parseInt(str));


			str= rs.getString("designation");
			employee.setDesignation(str);

			str= rs.getString("status");
			employee.setStatus(str);

			str= rs.getString("departmentid");
			employee.setDepartmentId(str);

			str= rs.getString("role");
			employee.setRole(str);

			str= rs.getString("address");
			employee.setAddress(str);

			str= rs.getString("isAdmin");
			employee.setIsAdmin(str);

			str= rs.getString("isManager");
			employee.setIsManager(str);

		}
		
		/**closing the connection
		 * 
		 */
		connection.close();
		rs.close();
		System.out.println("returned");
		return employee;



	}




}
