<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Travel Manager - Create Account</title>
	</head>
	<body>
		<h2>Travel Manager - Create Account SPRING</h2>
		<br/>
		<sf:form method="post" modelAttribute="account">
			Please enter your username and password:<br/><br/>
			&nbsp; Username &nbsp; <input type="text" name="username"/><br/><br/>
			&nbsp; <i><small> &nbsp; *Must begin with a letter, be at least 8 characters, can contain numbers, but cannot contain spaces.</small></i><br/><br/>
			&nbsp; Password &nbsp; <input type="password" name="password"/><br/><br/>
			&nbsp; <i><small> &nbsp; *Must be at least 8 characters, but cannot contain spaces.</small></i><br/><br/>
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="Create New Account"/>
		</sf:form>
	</body>
</html>