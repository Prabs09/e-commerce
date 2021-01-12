<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="profileheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
table,th,td
{
	border:2px solid black;
	border-collapse: collapse;
}
table.center
{
margin-left: auto;
margin-right: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>Your Profile</title>
</head>
<body>
<div class="text">
Welcome ${user}, 
</div>
<table class="center">
<tr>
	<th>Fields</th>
	<th>Records</th>
</tr>
<tr>
	<td>First Name</td>
	<td>${info.getFirstname()}</td>
</tr>

<tr>
	<td>Last Name</td>
	<td>${info.getLastname()}</td>
</tr>

<tr>
	<td>Address</td>
	<td>${info.getAddress()}</td>
</tr>

<tr>
	<td>contact</td>
	<td>${info.getContact()}</td>
</tr>

<tr>
	<td>pincode</td>
	<td>${info.getPincode()}</td>
</tr>

<tr>
	<td>email</td>
	<td>${info.getEmail()}</td>
</tr>
</table> 

<form action="newprofile.jsp" method="post">
<input type="submit" value="add profile">
</form>

</body>
</html>