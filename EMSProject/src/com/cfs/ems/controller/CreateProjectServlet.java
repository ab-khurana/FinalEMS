package com.cfs.ems.controller;

// team 2
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cfs.ems.dao.GetData;

public class CreateProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		request.getRequestDispatcher("/header.html").include(request, response);

		out.println("<table>'");

		out.println("<tr>");
		out.println("<td>");
		request.getRequestDispatcher("/linklist.jsp")
				.include(request, response);
		out.println("</td>");

		// CreateProject html configuration
		out.println("<td align = 'left'><form action='ProjectDeatilsInput' method='post'>"
				+ "Project  Id: <input type='text' name ='ProjectId' value='' min='0' required>"
				+ "<br><br>"
				+ "Project Name: <input type='text' name ='ProjectName' value='' required>"
				+ "<br><br>"
				+ "Start Date(YYYY-MM-DD Format Only): <input type='text' id='DATE' name='start_date' value='' min='01-01-2000'max='30-12-2015' required>"
				+ "<br><br>"
				+ "End Date(YYYY-MM-DD Format Only):   <input type='text' name ='end_date' value=' 'min='01-01-2016'max='30-12-2035' required>"
				+ "<br><br>");

		out.println("Manager Id:    <select name='Dropdown'>");

		List<String> l = null;
		try {
			l = new GetData().getData("employee_id", "employee_details");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String a : l) {
			out.println("<option>" + a + "</option>");
		}
		out.println("</select>");
		List<String> l1 = null;
		out.println("<br><br>" + "Client Id:    <select name='Dropdown1'>");

		try {
			l1 = new GetData().getData("client_id", "client_details");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < l1.size(); i++) {

			out.println("<option>" + l1.get(i) + "</option>");
		}

		out.println("</select> "
				+ "<br><br>"
				+ "Status : <select name='Status'>"
				+ "<option>Active</option>"
				+ "<option>InActive</option> "
				+ "</select>"
				+ "<br><br>"
				+ "Description:  <input type='text' name ='Description' value=' ' required>"
				+ "<br><br>" + "<input type='submit' value='Submit'>"
				+ " <input type ='reset' value='Reset'>" + "</form>");

		out.println("<br><form action='CreateNewClient' method='post'>"
				+ "<input type='submit' value='Create New Client'>"
				+ "</form></td>");

		out.println("</tr>");
		out.print("</table>");

		request.getRequestDispatcher("/footer.html").include(request, response);

	}

}
