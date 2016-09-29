package com.cfs.ems.service;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.dao.SearchDao;
import com.cfs.ems.dao.SearchDaoImp;
import com.cfs.ems.domain.Employee;

/**
 * @author Lakshit
 *
 */
public class SearchServiceImp implements SearchService {
	/**
	 * @param request is request object
	 * @return Employee object
	 * @throws Exception
	 */
	public Employee search(HttpServletRequest request) throws Exception {

		// Receiving user input

		String id = request.getParameter("id");

		System.out.println("ID : " + id);

		Employee emp = new Employee();

		emp.setEmployeeId(id);

		SearchDao doi = new SearchDaoImp();
		Employee s = doi.search1 (emp);

		return s;
	}

}
