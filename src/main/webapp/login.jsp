<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body align="center" style="margin-top: 50px">
	<%
	String msg = (String) request.getAttribute("message");
	if (msg != null) {
	%>
	<%=msg%>
	<%
	}
	%>
	<h1 align="center">User Login</h1>
	<div align="center"
		style="margin-bottom: 20px; margin-top:20px; width: 30%; display: flex; justify-content: center; margin-left: 550px;">
	<form action="login" method="post">
		<input type="text" class="form-control form-control-sm" name="email" placeholder="Email"><br> <br>
		<input type="text" class="form-control form-control-sm" name="password" placeholder="Password"><br> <br>
		<input type="submit" class="btn btn-primary" value="Login">
	</form>
	</div>
</body>
</html>