<%@page import="java.util.LinkedList"%>
<%@page import="com.cfs.ems.domain.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of _Projects</title>
<script language="javascript">
function deleteRecord(id){
    var f=document.form;
    f.method="post";
    f.action='deletes?id='+id;
    f.submit();
}
function editRecord1(id){
    var f=document.form;
    f.method="post";
    f.action='editallocate?id='+id;
    f.submit();
}
</script>
</head>
<%@include file="header.html"%>
<body>
<table height="100px"> <tr><td><%@include file="linklist.jsp"%></td>
		<td>
<form method="post" name="form">
	<%
	LinkedList<ProjectAllocation> dataList = (LinkedList) request.getSession().getAttribute("employeeList");
	java.util.Iterator itr = dataList.iterator();
	%>
	<table border='black' cellpadding = '5'>
	<tr>
	<th>Project Allocation ID</th>
	<th>Project ID</th>
	<th>Project Name</th>
	<th>Employee ID</th>
	
	<th>Designation</th>
	<th>Start Date</th>
	<th>End Date</th>
	<th>Status</th>
	</tr>
	<%
	for(ProjectAllocation pa : dataList){
		%>
		</tr>
		<td><%=pa.getProjectAllId()%></td>
		<td><%=pa.getProjectId()%></td>
		<td><%=pa.getProjectName()%></td>
		<td><%=pa.getEmployeeId()%></td>
		    
		<td><%=pa.getDesignation()%></td>
		<td><%=pa.getStartDate()%></td>
		<td><%=pa.getEndDate()%></td>
		<td><%=pa.getStatus()%></td> 
		<td> <input name="edit" type = 'button' value ='EDIT'  onclick="editRecord1(<%=pa.getProjectAllId()%>);"></td>
		<td> <input name="delete" type = 'button' value ='DELETE' onclick="deleteRecord(<%=pa.getProjectAllId()%>);"></td>
		</tr><%
	}
	%>
	</table>
	</td>
	</tr>
	</table>
</form>
<%@include file="footer.html"%>
</body>
</html>