package com.cfs.ems.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import com.cfs.ems.domain.LoginPOJO;
import com.cfs.ems.domain.ProjectAllocation;
import com.cfs.ems.dao.*;
import com.cfs.ems.domain.*;






public class LoginService implements LoginInterface {

	@Override
	public Status login(HttpServletRequest request) throws Exception {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginPOJO loginPojo = new LoginPOJO();
		loginPojo.setUsername(username);
		loginPojo.setPassword(password);
		
		ListOfProjectsDatabase ldao = new ListOfProjectsDatabase();
		Status status = ldao.loginToDB(loginPojo);

		
		
		return status;
	}

	@Override
	public Boolean deleteService(String request) throws Exception {
		String employeeId=request;
		System.out.println("employeeId: "+employeeId);
		
		ProjectAllocation employee = new ProjectAllocation();
		employee.setProjectAllId(employeeId);
		

		ListOfProjectsDatabase employeeDaoMyD = new ListOfProjectsDatabase();
		Boolean status1 = employeeDaoMyD.delete(employee);
		
		return status1;
	}

	@Override
	public Boolean projectAllocations(HttpServletRequest request)
			throws Exception {
		String projectName = request.getParameter("projectname");
		String employeeName = request.getParameter("employeename");
		String designation = request.getParameter("designation");
		String startDate = request.getParameter("startdate").toString();
		String endDate = request.getParameter("enddate").toString();
		String status="active";
		
		ProjectAllocation proall = new ProjectAllocation();
		proall.setProjectName(projectName);
		proall.setEmployeeName(employeeName);
		proall.setDesignation(designation);
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date startDates = new java.sql.Date(formatter.parse(startDate).getTime());
		proall.setStartDate(startDates);
		
		java.sql.Date endDates = new java.sql.Date(formatter.parse(endDate).getTime());
		proall.setEndDate(endDates);
		
		proall.setStatus(status);
		
		ListOfProjectsInterface alldoa = new ListOfProjectsDatabase();
		Boolean s = alldoa.allocateEmployee(proall);
		
		
		return s;
	}

	@Override
	public ProjectAllocation editAllocate(String id) throws Exception {
		
		ProjectAllocation emp = new ProjectAllocation();
System.out.println(id);
		emp.setProjectAllId(id);

		ListOfProjectsInterface doi = new ListOfProjectsDatabase();
		ProjectAllocation s = doi.updateAllocate1(id);

		return s;
	}

	@Override
	public boolean editProjectAllocation1(HttpServletRequest request)
			throws Exception {
		boolean st=false;
		
		
		String projectName = request.getParameter("projectname");
		String projectAllid = request.getParameter("projectAllid");
		String designation = request.getParameter("designation");
		String startDate = request.getParameter("startdate").toString();
		String endDate = request.getParameter("enddate").toString();
		
		
		ProjectAllocation proall = new ProjectAllocation();
		proall.setProjectName(projectName);
		proall.setProjectAllId(projectAllid);
		proall.setDesignation(designation);
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.sql.Date startDates = new java.sql.Date(formatter.parse(startDate).getTime());
		proall.setStartDate(startDates);
		
		java.sql.Date endDates = new java.sql.Date(formatter.parse(endDate).getTime());
		proall.setEndDate(endDates);
		
	
		
		ListOfProjectsInterface alldoa = new ListOfProjectsDatabase();
		Boolean s = alldoa.updateprojectAllocation(proall);
		
		
		return s;
	}



	

	

	
	


	/*public String getEmployeeNameService(HttpServletRequest request) throws Exception {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginPOJO loginPojo = new LoginPOJO();
		loginPojo.setUsername(username);
		loginPojo.setPassword(password);
		
		LoginDAO ldao = new LoginDAO();
		String empName = ldao.getEmployeeNameDAO(loginPojo);
		

		
		
		return empName;
	}*/


	
	

}
