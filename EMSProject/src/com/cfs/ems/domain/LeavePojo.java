package com.cfs.ems.domain;

import java.sql.Date;

public class LeavePojo {
private Date startDate;
private Date endDate;
private String leaveId;
private String employeeId;
private String managerId;
private String reason;
private String Status;
public String getStatus() {
	return Status;
}
public String setStatus(String Status) {
	return this.Status = Status;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getLeaveId() {
	return leaveId;
}
public String setLeaveId(String leaveId) {
	return this.leaveId = leaveId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getManagerId() {
	return managerId;
}
public void setManagerId(String managerId) {
	this.managerId = managerId;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
}
