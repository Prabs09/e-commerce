<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="loginheader.jsp" %>
<!DOCTYPE html>
<html>
<body>
<%
	int check=(int) session.getAttribute("login");
	if( check!=1 )
	{
		response.sendRedirect("homepage.jsp");
	}
	
%>
Welcome ${user}
</body>
</html>