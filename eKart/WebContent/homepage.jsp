<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="headers.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-kart</title>
</head>
<body>
<%
		String chk=request.getParameter("reg");
		if(chk.equalsIgnoreCase("false"))
			out.print("Registration failed. Re-register!!");
	 
%>
</body>
</html>