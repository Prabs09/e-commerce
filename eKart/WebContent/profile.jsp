<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="profileheader.jsp" %>
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

<form action="<%=request.getContextPath()%>/profile" method="get">
<input type="submit" value="show profile">
</form>

</body>
</html>