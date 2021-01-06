<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Profile</title>
</head>
<body>
<form action="\profile" method="post">

<label for="fname">First Name:</label>
<input type="text" id="fname" name="fname">

<label for="lname">Last Name:</label>
<input type="text" id="lname" name="lname">

<label for="address">Address:</label>
<input type="text" id="address" name="address">

<label for="contact">contact:</label>
<input type="text" id="contact" name="contact">

<label for="pincode">pincode:</label>
<input type="text" id="pincode" name="pincode">

<button type="submit">Submit</button>
<button type="reset">reset</button>
</form>
</body>
</html>