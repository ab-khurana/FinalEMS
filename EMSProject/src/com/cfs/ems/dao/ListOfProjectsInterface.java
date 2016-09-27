package com.cfs.ems.dao;

import java.util.LinkedList;
import java.util.List;

import com.cfs.ems.domain.LoginPOJO;
import com.cfs.ems.domain.ProjectAllocation;
import com.cfs.ems.domain.Status;

public interface ListOfProjectsInterface {
	
	public LinkedList<ProjectAllocation> extractData();
	public  List<?> loguser();
	public  List<?> emplog();
	public Boolean allocateEmployee(ProjectAllocation e) throws Exception;
	public Boolean updateprojectAllocation(ProjectAllocation e) throws Exception;
	public ProjectAllocation updateAllocate1(String id) throws Exception;
	public Status loginToDB(LoginPOJO lpo) throws Exception;
	public Boolean delete(ProjectAllocation e) throws Exception;
}
