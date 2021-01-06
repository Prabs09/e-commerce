<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="homeheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<%
		Boolean str=(Boolean) session.getAttribute("logchk");
		if(str)
			response.sendRedirect("login_succ.jsp");
		else
			out.print("error login, check your credentials again");
%>

<form action="/login">
<label for="email" inputmode="email">Id:</label>
<input type="email" id="email" name="email">
<label for="pass">Password:</label>
<input type="password" id="pass" name="pass">
<br><br>
<button type="submit">Log In</button>
<button type="reset">Clear</button>
</form>

</body>
</html>