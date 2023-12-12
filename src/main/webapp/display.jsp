<%@page import="jsp_library.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
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
<body style="margin: 20px">
	<%
	List<Book> book = (List) request.getAttribute("list");
	%>
	<h1 align="center">Books Information</h1>
	<div align="center"
		style="margin-bottom: 20px; width: 30%; display: flex; justify-content: center; margin-left: 500px;">
		<form action="saveBook" method="post" style="">
			<input type="number" class="form-control form-control-sm" name="id"
				placeholder="ID"><br> <br> <input type="text"
				name="name" class="form-control form-control-sm" placeholder="Name"><br>
			<br> <input type="text" name="author"
				class="form-control form-control-sm" placeholder="Author"><br>
			<br> <input type="tel" name="price"
				class="form-control form-control-sm" placeholder="Price"><br>
			<br> <input type="text" name="genre"
				class="form-control form-control-sm" placeholder="Genre"><br>
			<br> <input type="submit" class="btn btn-primary"
				value="Add Book">
		</form>
	</div>
	<table class="table" border="1px">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Author</th>
				<th>Price</th>
				<th>Genre</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
		for (Book b : book) {
		%>
		<tbody>
			<tr>
				<td><%=b.getId()%></td>
				<td><%=b.getName()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getGenre()%></td>
				<td><a href="delete?id=<%=b.getId()%>"><button
							class="btn btn-danger">Delete</button></a> <a
					href="update?id=<%=b.getId()%>"><button class="btn btn-warning">Update</button></a></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
</body>
</html>