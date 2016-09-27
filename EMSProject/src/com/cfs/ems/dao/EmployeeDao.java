package com.cfs.ems.dao;
import java.util.LinkedList;

import com.cfs.ems.domain.Employee;
public interface EmployeeDao {
	public LinkedList<Employee>  view(Employee e) throws Exception;
}
