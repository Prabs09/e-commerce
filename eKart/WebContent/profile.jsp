<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>

<%
	int check=(int) session.getAttribute("login");
	if( check!=1 )
	{
		response.sendRedirect("homepage.jsp");
	}
%>

<form action="/profile" method="get">
<button type="button">show profile</button>
</form>
<form action="newprofile.jsp" method="post">
<button type="button">add profile</button>
</form>
</body>
</html>