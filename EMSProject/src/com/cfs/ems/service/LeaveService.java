package com.cfs.ems.service;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.cfs.ems.dao.LeaveDao;
import com.cfs.ems.domain.LeavePojo;

public class LeaveService {
	
	
	//Apply the leave in general;
	public	Boolean  applyLeaveService(LeavePojo leavePojo) throws Exception {
	LeaveDao leaveDao =new  LeaveDao();
		Boolean status = leaveDao.applyLeaveDao(leavePojo);
		if (status){return true;}
		else{return false;}
	}

	
	
	//to view the leave list to the employee that he have applied till date;
	public List<LeavePojo> viewapplyLeaveService(String empId) throws Exception{
	LeaveDao leaveDao =new  LeaveDao();
	ResultSet resultset = leaveDao.viewapplyLeaveDao(empId);
	List<LeavePojo> viewList= new LinkedList<LeavePojo>();
	while(resultset.next())
	{
	LeavePojo leavePojo = new LeavePojo();
	leavePojo.setEmployeeId(resultset.getString("employee_id") );
	leavePojo.setEndDate(resultset.getDate("startdate"));
	leavePojo.setStartDate(resultset.getDate("enddate"));
	leavePojo.setManagerId(resultset.getString("Manager_id"));
	leavePojo.setReason(resultset.getString("reason"));
	leavePojo.setStatus(resultset.getString("status"));
	leavePojo.setLeaveId(resultset.getString("Leave_id"));
	viewList.add(leavePojo);
	}
	return viewList;
	}



	//to view the manager the list of the applied leave by employees
	public List<LeavePojo> LeaveListService(String empId) throws Exception{
	LeaveDao leaveDao =new  LeaveDao();
	System.out.println("SERVICE"+empId);
	ResultSet resultset = leaveDao.LeaveListDao(empId);
	List<LeavePojo> viewList= new LinkedList<LeavePojo>();
	while(resultset.next())
	{
		LeavePojo leavePojo = new LeavePojo();
		leavePojo.setEmployeeId(resultset.getString("employee_id") );
		leavePojo.setEndDate(resultset.getDate("startdate"));
		leavePojo.setStartDate(resultset.getDate("enddate"));
		leavePojo.setManagerId(resultset.getString("Manager_id"));
		leavePojo.setReason(resultset.getString("reason"));
		leavePojo.setStatus(resultset.getString("status"));
		leavePojo.setLeaveId(resultset.getString("Leave_id"));
		viewList.add(leavePojo);
		
	}
	return viewList;
	}

	
	
	//update the status to approved or reject by the manager
	public Boolean updatedLeaveListService(String updatedStatus,String leave_id) throws Exception {
	LeaveDao leaveDao =new  LeaveDao();
	
	Boolean updateStatus =leaveDao.updatedLeaveListDao(updatedStatus,leave_id);
	return updateStatus;
	}
}
