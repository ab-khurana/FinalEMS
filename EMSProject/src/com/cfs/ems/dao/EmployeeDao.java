package com.cfs.ems.dao;
import java.util.LinkedList;
import com.cfs.ems.domain.Employee;

//interface whose function is defined in EmployeeDaoImpl
/**
 * @author aadsharm
 *
 */
public interface EmployeeDao {
	
	//return type of function is a list
	/**
	 * @param e
	 * @return Linkedlist of employee
	 * @throws Exception
	 */
	public LinkedList<Employee>  view(Employee e) throws Exception;
}
