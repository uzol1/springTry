<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Signup page</h1>
	<hr>
	<form action="usersignup" method="post">
		<p style="color: red">${error}</p>
		first name <input type="text" name="fname"><br> <br>
		last name <input type="text" name="lname"><br> <br>
		user name <input type="text" name="username"><br> <br>
		password <input type="password" name="password"><br> <br>
		<input type="submit" value="signup"><br> <br>

	</form>
</body>
</html>