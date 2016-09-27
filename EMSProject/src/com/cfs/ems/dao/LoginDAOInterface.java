package com.cfs.ems.dao;

import com.cfs.ems.domain.LoginPOJO;
//import com.cg.ems.domain.ProjectAllocation;
import com.cfs.ems.domain.Status;

public interface LoginDAOInterface {
	
	public Status loginToDB(LoginPOJO lpo) throws Exception;
//	public String getEmployeeNameDAO(LoginPOJO lpo2) throws Exception;
//	public Boolean delete(ProjectAllocation e) throws Exception;

}
