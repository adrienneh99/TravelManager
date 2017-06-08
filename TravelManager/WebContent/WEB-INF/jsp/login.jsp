<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Travel Manager - Login</title>
	</head>
	<body>
		<br/>
			<sf:form method="post" modelAttribute="login">
				<sf:label path="username"></sf:label>
				<sf:label path="password"></sf:label>
				<h2><b>Welcome to Travel Manager</b></h2><br/>
				Please enter your username and password:<br/><br/>
				<sf:label path="username">Username: </sf:label>
				<sf:input path="username" cssClass="input"/>
				<sf:errors path="username" cssClass="error" />
				<br/><br/>
				<sf:label path="password">Password: </sf:label>
				<sf:password path="password" cssClass="input"/>
				<sf:errors path="password" cssClass="error" />
				<br/><br/>
				&nbsp; <input type="submit" name="login" value="Login"/>
				&nbsp; &nbsp; &nbsp; 
				&nbsp; <input type="submit" name="createAcct" value="Create New Account"/>
			</sf:form>
	</body>
</html>