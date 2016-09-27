package com.cfs.ems.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import com.cfs.ems.controller.ListOfProjectsServlet;
import com.cfs.ems.domain.Employee;
import com.cfs.ems.domain.LoginPOJO;
import com.cfs.ems.domain.ProjectAllocation;
import com.cfs.ems.domain.Status;



public class ListOfProjectsDatabase implements ListOfProjectsInterface {

	@Override
	public LinkedList<ProjectAllocation> extractData() {

		boolean status = false ;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

			String sql = "SELECT project_allocations.project_all_id, project_details.project_id, project_details.project_name, employee_details.employee_id, employee_details.first_name, employee_details.last_name, project_allocations.designation, project_allocations.start_date, project_allocations.end_date, project_allocations.status FROM ems.project_allocations, ems.project_details, ems.employee_details WHERE ems.project_allocations.project_id = ems.project_details.project_id AND ems.project_allocations.employee_id = ems.employee_details.employee_id AND ems.project_allocations.status = 'active';";

			PreparedStatement ps = con.prepareStatement(sql);


			ResultSet rs;
			rs = ps.executeQuery(sql);



			LinkedList<ProjectAllocation> list = new LinkedList<ProjectAllocation>();

			while(rs.next()){

				ProjectAllocation pa = new ProjectAllocation();
				pa.setProjectAllId(rs.getString(1));
				pa.setProjectId(rs.getString(2));
				pa.setProjectName(rs.getString(3));
				pa.setEmployeeId(rs.getString(4));
				//			pa.setEmployeeName(rs.getString(5),rs.getString(6));
				pa.setDesignation(rs.getString(7));
				pa.setStartDate(rs.getDate(8));
				pa.setEndDate(rs.getDate(9));
				pa.setStatus(rs.getString(10));
				list.add(pa);
			}


			con.close();  

			return (list);

		}

		catch(Exception e){

			System.out.println(e);
		}

		return null;

	}

	@Override
	public List<?> loguser() {
		List list=new ArrayList();


		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery( "SELECT project_name FROM project_details ");

			while(rs2.next()){
				list.add(rs2.getString("project_name"));

			}

		}catch(Exception e){
			e.printStackTrace();

		}

		return list;
	}

	@Override
	public List<?> emplog() {
		List list=new ArrayList();


		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			Statement stmt = conn.createStatement();
			ResultSet rs2 = stmt.executeQuery( "SELECT first_name FROM employee_details");

			while(rs2.next()){
				list.add(rs2.getString("first_name"));

			}

		}catch(Exception e){
			e.printStackTrace();

		}

		return list;
	}

	@Override
	public Boolean allocateEmployee(ProjectAllocation proall) throws Exception {
		boolean status;
		int project_all_Id=0;
		String projectId = null;
		String employeeId = null;

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");

		String sqlselect1="select project_id from project_details where project_name=?";
		PreparedStatement stmt1 = conn.prepareStatement(sqlselect1);
		stmt1.setString(1, proall.getProjectName());

		ResultSet rse = stmt1.executeQuery();
		while(rse.next()){
			projectId=rse.getString("project_id");
		}

		String sqlselect2="select project_all_id from project_allocations order by project_all_id DESC LIMIT 1";
		PreparedStatement stmt2 = conn.prepareStatement(sqlselect2);

		ResultSet rse1 = stmt2.executeQuery();
		while(rse1.next()){
			project_all_Id = rse1.getInt("project_all_id");

		}


		String sqlselect="select employee_id from employee_details where first_name=?";
		java.sql.PreparedStatement stmt = conn.prepareStatement(sqlselect);
		stmt.setString(1, proall.getEmployeeName());

		ResultSet rs2 = stmt.executeQuery();
		while(rs2.next()){
			employeeId=rs2.getString("employee_id");
		}

		String sql = "insert into project_allocations (project_all_id,project_id, employee_id, designation, start_date, end_date, status) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		project_all_Id=project_all_Id+1;
		String project_all_Id1=Integer.toString(project_all_Id);
		ps.setString(1, (project_all_Id1));
		ps.setString(2, projectId);
		ps.setString(3, employeeId);
		ps.setString(4, proall.getDesignation());
		ps.setDate(5, (Date) proall.getStartDate());
		ps.setDate(6, (Date) proall.getEndDate());
		ps.setString(7, proall.getStatus());

		int result = ps.executeUpdate();


		if(result>0) {

			status = true;
		} else {
			status = false;
		}		


		return status;


	}

	@Override
	public ProjectAllocation updateAllocate1(String id)
			throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");    
		Statement stmt=con1.createStatement();  

		System.out.println(id);

		ResultSet rs=stmt.executeQuery("select * FROM project_allocations WHERE project_all_id ="+id+"");


		ProjectAllocation e1= new ProjectAllocation();

		while (rs.next()) {

			e1.setProjectAllId(rs.getString("project_all_id"));
			e1.setEmployeeId(rs.getString("employee_id"));
			e1.setDesignation(rs.getString("designation"));
			e1.setStartDate(rs.getDate("start_date"));
			e1.setEndDate(rs.getDate("end_date"));
			e1.setProjectId(rs.getString("project_id"));

		}

		con1.close();
		return e1;
	}

	@Override
	public Boolean updateprojectAllocation(ProjectAllocation e1)
			throws Exception {

		boolean st=false;
		String projectId=null;

		Class.forName("com.mysql.jdbc.Driver");

		Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root"); 

		String sqlselect1="select project_id from project_details where project_name=?";
		PreparedStatement stmt1 = con2.prepareStatement(sqlselect1);
		stmt1.setString(1, e1.getProjectName());

		ResultSet rse = stmt1.executeQuery();
		while(rse.next()){
			projectId = rse.getString("project_id");
		}

		PreparedStatement ps= con2.prepareStatement("update project_allocations set project_id=?, designation=?,start_date=?,end_date=? where  project_all_id=?");  


		ps.setString(1,projectId);  
		ps.setString(2, e1.getDesignation());
		ps.setDate(3, (Date) e1.getStartDate());
		ps.setDate(4, (Date) e1.getEndDate());
		ps.setString(5, e1.getProjectAllId());



		int r=ps.executeUpdate();

		if(r>0){
			st=true;
		}
		else {
			st=false;
		}
		con2.close();
		return st;

	}

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
			if(rs.getString(4).equals("y")){
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
			if(rs.getString(4).equals("n")){
				status.setStatus(2);
				String empId = rs.getString(1);
				status.setEmpId(empId);
				PreparedStatement ps2 = con.prepareStatement("select employee_details.First_Name, employee_details.Last_Name from employee_details inner join login_table on login_table.employee_id = employee_details.Employee_ID where login_table.employee_id = ?;");
				ps2.setString(1, empId);
				ResultSet rs2 =  ps2.executeQuery();
				rs2.next();
				status.setEmpName(rs2.getString(1));
				status.setEmpLastName(rs2.getString(2));
			}
		}
		else
			status.setStatus(0);
		con.close();


		return status;
	}

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

	@Override
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
	}




}






