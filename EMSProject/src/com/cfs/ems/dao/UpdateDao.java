package com.cfs.ems.dao;

import com.cfs.ems.domain.Employee;

public interface UpdateDao {
	
	public Employee update1 (Employee e) throws Exception;
	
	public boolean updateedit (Employee e) throws Exception;

}
