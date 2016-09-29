package com.cfs.ems.dao;

import com.cfs.ems.domain.Employee;

/**
 * @author Valencia and Darshandeep
 *
 */
public interface UpdateDao {
	/**
	 * @param e is Employee object
	 * @return Employee object
	 * @throws Exception
	 */
	public Employee update1 (Employee e) throws Exception;
	/**
	 * @param e is Employee object
	 * @return boolean object
	 * @throws Exception
	 */
	public boolean updateedit (Employee e) throws Exception;

}
