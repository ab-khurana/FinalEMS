package com.cfs.ems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.CreateClientDao;
import com.cfs.ems.dao.CreateProjectDao;
import com.cfs.ems.dao.GetData;
import com.cfs.ems.domain.ClientDomain;
import com.cfs.ems.domain.ProjectDomain;

public class ClientInputDetails extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		System.out.println("in client input details");
		String client_id =request.getParameter("ClientId");
		String client_name = request.getParameter("ClientName");
		
		String description = request.getParameter("Description");
		
		System.out.println(client_id +client_name +description);
		ClientDomain client=new ClientDomain();
		
		client.setClientId(client_id); 
		client.setClientName(client_name);
		client.setDescription(description);
		
		
		System.out.println(client.getClientId() +client.getClientName() +client.getDescription());
		int a=0;
		try {
			a = new CreateClientDao().insertIntoDatabase(client);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a);
		RequestDispatcher rd=request.getRequestDispatcher("/CreateProject");
		rd.forward(request, response);
		
	}

	
}
