<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ page import="java.util.*" %>
<body>
<center>
				<font size="5" color="Red">Project Allocations:</font>
				<br><br>
				<form action="allocate" method="post">
				<%
				java.util.List dataList = (List) request.getSession().getAttribute("somename");
				java.util.Iterator itr = dataList.iterator();
				
				%>
				<br><br><br><br><br><br><br><br>
				Project name:	<select name="projectname">
					
					<%while(itr.hasNext()) {
					String projectname=(String)itr.next();
					%>
						  <option value="<%out.print(projectname);%>"><%out.print(projectname);%></option>
    						
					<% }%>
				</select>
				<br><br>
				Designation: <select name="designation">
								<option value="designer">Designer</option>
								<option value="developer">Developer</option>
								<option value="tester">Tester</option>
								<option value="Associate Consultant">Associate Consultant</option>
								<option value="Consultant">Consultant</option>
								<option value="Software Engineer">Software Engineer</option>
							</select>
							<br><br>
				<%
				java.util.List dataList1 = (List) request.getSession().getAttribute("somename1");
				java.util.Iterator itr1 = dataList1.iterator();
				
				%>
				Employee name:	<select name="employeename">
					
					<%while(itr1.hasNext()) {
						String employeename=(String)itr1.next();
					%>
						  <option value="<%out.print(employeename);%>"><%out.print(employeename);%></option>
    						
					<% }%>
				</select>	
				<br><br>
					Start Date (YYYY-MM-DD Format Only): <input type="date" name="startdate" value="">
					<br><br>
					End Date (YYYY-MM-DD Format Only): <input type="date" name="enddate" value="">
					<br><br>

					
					<input type="submit" value="Allocate">
					
				</form>
		</center>

</body>
</html>