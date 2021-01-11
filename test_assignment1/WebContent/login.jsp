<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Please Enter Login Credentials</h2>
<form action="Login">
<input type="hidden" name="requestAction" value="Login" />
<h2 style="color:red">
	<% if(null!=request.getAttribute("message")){ %>
	<%=request.getAttribute("message") %>
	<% } %>
</h2>
<table>
	<tr>
		<td> Username: </td>
		<td> <input type="text" name="username" /> </td>
	</tr>
	<tr>
		<td> Password: </td>
		<td> <input type="password" name="password" /> </td>
	</tr>
	<tr>
		<td> &nbsp; </td>
		<td> <input type="submit" name="Login" value="Login"/> </td>
	</tr>
</table>
</form>
</body>
</html>