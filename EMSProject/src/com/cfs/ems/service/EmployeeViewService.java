package com.cfs.ems.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.cfs.ems.dao.PersonalInformationDao;
import com.cfs.ems.dao.ChangePasswordDao;
import com.cfs.ems.domain.Employee;

/**
 * @author Christal Sheeba , Asham Ahmad, Yogesh Palanivel & Abhinav Chaudhary
 *  EmployeeViewService is a service class that serves two purposes via two methods
 *  First one is getPersonalInformation that checks and returns employee object
 *  Second one is changePasword that changes password provided that all criteria for password change is fulfilled
 */
public class EmployeeViewService {
	
	
	/**
	 * @param request
	 * @param empId
	 * @param 
	 * @return Instance of Employee class 
	 * @throws Has a try-catch block
	 */
	public Employee getPersonalInformation ( HttpServletRequest request)
	{
        Employee employee =null;
		
		String empId = (String)request.getSession().getAttribute("empId");
		PersonalInformationDao information= new PersonalInformationDao();
		//AccessAddress access = new AccessAddress();
		try {
			
		 employee=	information.getInfo(empId);
		
		 request.getSession().setAttribute("emp", employee);
		
		 //response.getWriter().println(employee.getEmployeeId());
		
//		 address = access.retrieveAddress(empId);
		// request.getSession().setAttribute("add", address);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		//HttpSession session = request.getSession();
		
		// request.getSession().setAttribute("add",address);
		/*RequestDispatcher rd = request.getRequestDispatcher("PersonalInformation.jsp");
		rd.forward(request, response);*/
		
		
		return employee;
		
	}
	
	
	/**
	 * @param request
	 * @param It checks the length of password, the similarity between newPassword & confirmPassword 
	 * and whether the operation performed is successful or not
	 * @return int type status back to ChangePasswordServlet.
	 * @throws IOException
	 */
	public int changePasword(HttpServletRequest request) throws IOException
	{   
		
		int status;
		String oldPassword= request.getParameter("password");
		String newPassword= request.getParameter("newpassword");
		String confirmNewPassword= request.getParameter("confirmpassword");
		/** Checks for password length*/
			if(newPassword.length()<8)
		
		{
			return -1;
		//out.println("Invalid Password");
		}
			/** Checks for password similarity*/
		else if(newPassword.equals(confirmNewPassword))
		{
			/** Creates instance of ChangePasswordDao*/
		ChangePasswordDao changePassword = new ChangePasswordDao();
		     
		try {
			 status = changePassword.changePassword(oldPassword,newPassword,request);
		    return status;
		    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			e.getMessage();
		}
		}
		
		return -2;
	
	}
	

}
