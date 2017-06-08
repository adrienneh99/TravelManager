<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Travel Profile</title>
	</head>
	<body>
	<h2>Travel Profile</h2>
		<sf:form method="post" modelAttribute="profile">
			<f:formatDate value="${acctKey.profile.dateOfBirth}" type="date" pattern="MM/dd/yyyy" var="dob" />
			<table>
				<tr>
					<td colspan="3">*All Fields Required</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" value= "${acctKey.profile.firstName}" ></td>
					<td></td>
				</tr>
				<tr>
					<td>Middle Name or Initial</td>
					<td><input type="text" name="middleName" value= "${acctKey.profile.middleName}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" value= "${acctKey.profile.lastName}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="primaryAddress" value= "${acctKey.profile.primaryAddress}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="primaryCity" value= "${acctKey.profile.primaryCity}" /></td>
					<td></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="primaryState" value= "${acctKey.profile.primaryState}" /></td>
					<td>(XY)</td>
				</tr>
				<tr>
					<td>Zip</td>
					<td><input type="text" name="primaryZip" value= "${acctKey.profile.primaryZip}" /></td>
					<td>(#####)</td>
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="text" name="primaryEmail" value= "${acctKey.profile.primaryEmail}"/></td>
					<td></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="primaryPhone" value= "${acctKey.profile.primaryPhone}" /></td>
					<td>(###-###-####)</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" value= "${acctKey.profile.gender}" /></td>
					<td>M or F</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="text" name="dateOfBirth" value="${dob}"/></td>
					<td>(MM/DD/YYYY)</td>
				</tr>
				<tr>
					<td>Passport Number</td>
					<td><input type="text" name="passportNum" value="${acctKey.profile.passportNum}" /></td>
					<td>(#########)</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" name="cancel" value="Cancel"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" name="save" value="Save"/>
					</td>
				</tr>
			</table>
			<input type="hidden" name="accountId" value="${acctKey.profile.accountId}"/>
		</sf:form>
	</body>
</html>