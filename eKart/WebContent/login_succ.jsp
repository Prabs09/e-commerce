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
<%@include file="content.jsp" %>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="HSRNDBL3J8WNL">
<input type="image" src="https://www.paypalobjects.com/en_GB/i/btn/btn_buynowCC_LG.gif"  name="submit" alt="PayPal – The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/en_GB/i/scr/pixel.gif" width="1" height="1">
</form>

</body>
</html>