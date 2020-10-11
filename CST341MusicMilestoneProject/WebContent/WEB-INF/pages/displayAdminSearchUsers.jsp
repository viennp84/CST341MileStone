<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="form">
		<h2>User List</h2>
		<table>
			<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Gender</th>
				<th>Username</th>

			</tr>
		</thead>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.getFirstName()}</td>
					<td>${user.getLastName()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getPhone()}</td>
					<td>${user.getGender()}</td>
					<td>${user.getUsername()}</td>
					
				<tr>
			</c:forEach>
		</table>
	</div>
</body>

</html>