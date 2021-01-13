<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="homeheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/register" method="post">
<label for="user">User:</label>
<input type="text" id="user" name="user">
<label for="email">Email:</label>
<input type="email" id="email" name="email">
<label for="pass">Password:</label>
<input type="password" id="pass" name="pass">
<br><br>
<input type="submit" value="sign up">
<input type="reset" value="Clear">
</form>
</body>
</html>