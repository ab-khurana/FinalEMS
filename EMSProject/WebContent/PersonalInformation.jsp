<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cfs.ems.domain.*" %>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <center>  <font size= "6">Personal Information</center> </font>
      
        <% com.cfs.ems.domain.Employee employee = (com.cfs.ems.domain.Employee)request.getSession().getAttribute("emp");
           //com.cg.ems.domain.Address address = (com.cg.ems.domain.Address)request.getSession().getAttribute("add");
        
       
       // out.write(employee.getAddress().getAddressLine1());
        %>
         <br>
        
       <align= "left"> <font size= "4"> Employee FirstName: </font> <% out.write(employee.getFirstName()); %>  &#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195; <font size= "4">Employee LastName:</font> <% out.write(employee.getLastName()); %>
       <br> 
       
        <font size= "4">  Employee Id: </font> <%  out.write(employee.getEmployeeId());  %>  &#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;  <font size= "4">Employee Gender: </font><% out.write(employee.getGender()); %>
        <br>
        
        
        <font size= "4">Employee PhoneNumber:</font> <% out.write(employee.getMobileNo()); %>  &#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;<font size= "4">Employee EmailId: </font> <% out.write(employee.getEmailId()); %>
        <br>
       
        <font size= "4">Employee Designation: </font> <% out.write(employee.getDesignation()); %>  &#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;&#8195;<!-- <font size= "4">Employee Skills: </font> --> <%-- <% out.write(employee.getSkills()); %> --%>
	    <br>
        
        <font size= "4">Employee Status: </font> <% out.write(employee.getStatus()); %>
        <br>
        
         <font size= "4">Employee Address: </font> <% out.write(employee.getAddress()); %>
        <br>
   
       <%--  <center> <font size= "6"> AddressDetails</center> </font>
       <font size= "4">Address Line 1:</font> <%  out.write(address.getAddressLine1()); %>
        <br>
        
        <font size= "4">Address Line 2: </font> <%  out.write(address.getAddressLine2()); %>
        <br>
        
        <font size= "4">Town: </font> <%  out.write(address.getTown()); %>
        <br>
        
        <font size= "4">City: </font> <%  out.write(address.getCity()); %>
       <br>
        
        <font size= "4">State: </font> <% out.write(address.getState()); %>
        <br>
        
        <font size= "4">Country: </font>  <%  out.write(address.getCountry()); %>
       <br>
        
        <font size= "4">Postal Code: </font> <%  out.write(address.getPostalCode()); %>
        <br>
        --%> 
        
</body>
</html>