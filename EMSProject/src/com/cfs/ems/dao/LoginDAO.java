package com.cfs.ems.dao;

import java.sql.*;

import com.cfs.ems.domain.LoginPOJO;
//import com.cg.ems.domain.ProjectAllocation;
import com.cfs.ems.domain.Status;

public class LoginDAO implements LoginDAOInterface{



	@Override
	public Status loginToDB(LoginPOJO lpo) throws Exception {

		Status status = new Status();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		//		Statement stmt = con.createStatement();
		PreparedStatement ps=con.prepareStatement("select * from login_table where employee_username=? and employee_password=?");
		ps.setString(1, lpo.getUsername());
		ps.setString(2, lpo.getPassword());

		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			if(rs.getString(4).equals("true")){
				status.setStatus(1);

				String empId = rs.getString(1);
				status.setEmpId(empId);
				PreparedStatement ps2 = con.prepareStatement("select employee_details.First_Name, employee_details.Last_Name from employee_details inner join login_table on login_table.employee_id = employee_details.Employee_ID where login_table.employee_id = ?;");
				ps2.setString(1, empId);
				ResultSet rs2 =  ps2.executeQuery();
				rs2.next();
				status.setEmpName(rs2.getString(1));
				status.setEmpLastName(rs2.getString(2));

			}
			if(rs.getString(4).equals("false")){
				//				status.setStatus(2);
				String empId = rs.getString(1);
				status.setEmpId(empId);
				PreparedStatement ps2 = con.prepareStatement("select employee_details.First_Name, employee_details.Last_Name,employee_details.IsManager from employee_details inner join login_table on login_table.employee_id = employee_details.Employee_ID where login_table.employee_id = ?;");
				ps2.setString(1, empId);
				ResultSet rs2 =  ps2.executeQuery();
				if(rs2.next()){
					if(rs2.getString(3).equals("y")){
						status.setStatus(2);
						status.setEmpName(rs2.getString(1));
						status.setEmpLastName(rs2.getString(2));
					}
					else {
						status.setStatus(3);
						status.setEmpName(rs2.getString(1));
						status.setEmpLastName(rs2.getString(2));
					}


				}
			}

		}
		else
			status.setStatus(0);
		con.close();


		return status;
	}

	/*@Override
	public String getEmployeeNameDAO(LoginPOJO lpo2) throws Exception {

		String employeeName = null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
		PreparedStatement ps1=con.prepareStatement("select * from login_table where employee_username=? and employee_password=?");

		ps1.setString(1, lpo2.getUsername());
		ps1.setString(2, lpo2.getPassword());

		ResultSet rs1 = ps1.executeQuery();


		if(rs1.next()){
			Integer empId = rs1.getInt(1);
			PreparedStatement ps2 = con.prepareStatement("select ems_table.First_Name from ems_table inner join login_table on login_table.employee_id = ems_table.Employee_ID where login_table.employee_id = ?;");
			ps2.setInt(1, empId);
			ResultSet rs2 =  ps2.executeQuery();
			rs2.next();
			employeeName = rs2.getString(1);
		}

		return employeeName ;
	}*/

	public static int NoRows(){
		Connection con = null;
		Statement stmt = null;
		int count = 0;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee_details");
			while(rs.next()){
				count++;				
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		return count;


	}

	/*@Override
	public Boolean delete(ProjectAllocation e) throws Exception {
		Boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

		String sql = "update project_allocations set status='inactive' WHERE project_all_id ="+e.getProjectAllId()+" ";

		Statement stmt=con.createStatement();
		int result=stmt.executeUpdate(sql);
		System.out.println("No. of records successfully deleted: "+result);

		if(result>0) {
			status = true;
		} else {
			status = false;
		}		
		return status;
	}*/


}
