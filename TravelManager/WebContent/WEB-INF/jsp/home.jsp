<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="domain.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="tm" uri="tmTag" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Travel Manager Main Menu</title>
	</head>
	<body>
	<h2>Travel Manager Main Menu</h2>
		<br/>
		<sf:form method="post" action="home">
			<c:choose>
				<c:when test="${acctKey.profile != null}">
					Welcome to Travel Manager ${acctKey.profile.firstName}
				</c:when>
				<c:otherwise>
					Welcome to Travel Manager. Please complete your Travel Profile.
				</c:otherwise>
			</c:choose>
			<br/><br/><br/>
				<input type="submit" name="travelprofile" value="Add / Update Travel Profile"/>
			<br/><br/>
				<input type="submit" name="travelpreferences" value="Add / Update Travel Preferences"/>
			<br/><br/>
				<input type="submit" name="admin" value="Admin"/>
			<br/><br/>
				<!-- <input type="submit" name="logout" value="Logout"/> -->
		</sf:form>
		<br/><br/><br/><br/>
		<small><tm:dateTime/></small>
	</body>
</html>

