<%@page import="com.cfs.ems.domain.ProjectAllocation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cfs.ems.dao.*"%>
<!-- team 3 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Project allocation</title>
</head>
<%@include file="header.html"%>
<body>

	
		<table height="100px">
			<td><%@include file="linklist.jsp"%></td>
			<td>
				<form action=updateprojectAllocation method=post>

					<%
						java.util.List<ProjectAllocation> dataList = (List) request
								.getSession().getAttribute("editProjectAllocation");
						java.util.Iterator itr = dataList.iterator();
					%>

					<%
						for (ProjectAllocation pa : dataList) {
					%>

					<%
						System.out.println("Inside editprojectservlet"
									+ pa.getProjectAllId());
					%>

					Project Allocation Id:<input type='text'
						value="<%=pa.getProjectAllId()%>" readonly name='projectAllid'>


					<%
						java.util.List dataList1 = (List) request.getSession()
									.getAttribute("projectName");
							java.util.Iterator itr1 = dataList1.iterator();
					%>
					<br> <br> Project name: <select name="projectname">


						<%
							while (itr1.hasNext()) {
									String projectname = (String) itr1.next();
						%>
						<option value="<%out.print(projectname);%>">
							<%
								out.print(projectname);
							%>
						</option>

						<%
							}
						%>
					</select> <br> <br> Employee Id :<input type='text'
						value="<%=pa.getEmployeeId()%>" readonly name='employeeId'>

					<br> <br> Designation: <select name="designation">
						<option value="designer">Designer</option>
						<option value="developer">Developer</option>
						<option value="tester">Tester</option>
						<option value="Associate Consultant">Associate Consultant</option>
						<option value="Consultant">Consultant</option>
						<option value="Software Engineer">Software Engineer</option>
					</select> <br> <br> Start Date :<input type='date'
						value="<%=pa.getStartDate()%>" name='startdate'> <br>
					<br> End Date :<input type='date' value="<%=pa.getEndDate()%>"
						name='enddate'> <br> <br> <br> <input
						type='submit' value='submit'> </input>
					<%
						}
					%>
				</form>
			</td>
		</table>

	<%@include file="footer.html"%>
</body>
</html>