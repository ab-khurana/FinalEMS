package com.cfs.ems.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.cfs.ems.dao.DeleteProjectDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProjectIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		String projectId= req.getParameter("pId");
		
		DeleteProjectDao delete= new DeleteProjectDao();
		try {
		int number=	delete.deleteProject(projectId);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		// TODO Auto-generated method stub
		
		resp.sendRedirect("project");
		
		/*RequestDispatcher rd=req.getRequestDispatcher("/project");
		 rd.forward(req, resp);*/
		
	}
	
	 
	

}
 