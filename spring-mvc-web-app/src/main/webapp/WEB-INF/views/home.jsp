<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello and welcome to Spring MVC Web</h1>
	<form action="sayName" method="post">
	Enter Name 
		<input type="text" name="fname"/>
		<input type="submit" value="click me"/>		
	</form>
	
	<br/>
	<h2>Try logging in</h2>
		<form action="login" method="post">
		User Name <input type="text" name="username"/>
		Password  <input type="text" name="password"/>
		</form>
		<span style="color:red">${errorMessage}</span>
		<br/>
		<a href="register">Click here to register</a>
</body>
</html>