package com.cfs.ems.dao;

import com.cfs.ems.domain.Employee;

/**
 * @author Lakshit
 *
 */
public interface SearchDao {
	/**
	 * @param e is Employee object
	 * @return Employee object
	 * @throws Exception
	 */
	public Employee search1(Employee e) throws Exception;

}
