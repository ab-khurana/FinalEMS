<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body><%-- <%@include file="header.html"%> --%>

	<table style="table-layout: auto;width: 15%;" border="2"
		cellpadding=5 cellspacing=5>
		</div>

		<tr>
			<td width="500%" height="500px" align="center">

				
				<div align="left">
					<p>
						<font color="grey" style=""> Welcome admin <%	out.print(request.getSession().getAttribute("firstName") + " "	+ request.getSession().getAttribute("lastName")	+ " with Employee ID as "
									+ request.getSession().getAttribute("empId"));
						%> !
						</font><br>
					<%-- <p>
						The Total Employees are
						<%	out.print(request.getSession().getAttribute("employeeCount"));	%>
						! --%>
					<DIV align="LEFT">
						<P>
							DASHBOARD<br> <button><a href="dashboard.jsp">Dashboard</a></button><br>
							<br>
						<P>
							<a href="view.html">EMPLOYEE</a><br>
							
							
							<!--  <button><br> <a href="listemployee.com">list employee</a><br></button>
							<button><a href="searchemployee.com">search employee</a><br></button>
							<button><a href="searchemployee.com">DELETE employee</a><br></button> -->
						<p>	PROJECT
							<form action="project" method="get">
							<input type = "submit" value="Project">
							</form>
							
							<!-- PROJECT<br> <button><a href="createproject.com">create project</a><br></button>
							<button><a href="listproject.com">list project</a><br> </button>
							<button><a href="searhproject.com">search project</a><br></button> -->
						<p>
							<!-- CLIENT<br> <a href="createclient.com">create client</a><br>
							<a href="listclient.com">list client</a><br> <a
								href="searhclient.com">search client</a><br> -->
						<p>
							PROJECT ALLOCATION<br>
							<form action="allocateform" method="post"> 
							<input type="submit" value="allocate project">
							</form> 
							
								<br> 
								 <!-- <a href="searchproject.com">search project</a><br> -->
								<a href="ListOfProjects.html">list  and edit projects</a><br>
								<!-- <a href="loginpage.jsp">remove employee from project</a><br> -->
						<p>
							<!-- LEAVE<br> <a href="apply leave.com">apply leave</a><br>
							<a href="approval.com">approval</a><br> -->
					</div>
		</tr>
	</table>
	</div>
	<%-- <%@include file="footer.html"%> --%>
</body>
</html>