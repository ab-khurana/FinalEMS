package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;
import com.cfs.ems.domain.*;

public interface LoginInterface {
	
	
	public Status login(HttpServletRequest request) throws Exception;
//	public String getEmployeeNameService(HttpServletRequest request) throws Exception;
	public Boolean deleteService(String request) throws Exception;
	public ProjectAllocation editAllocate(String id) throws Exception;
	
	public Boolean projectAllocations(HttpServletRequest request) throws Exception;
	
	public boolean editProjectAllocation1(HttpServletRequest request) throws Exception;
	

}
