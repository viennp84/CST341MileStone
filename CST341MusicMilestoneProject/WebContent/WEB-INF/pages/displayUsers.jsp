<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>List of Users</h2>
 
 <table border="1">
 	<th><lable>First name</lable></th>
 	<th><lable>Last name</lable></th>
 	
 	<c:forEach var="user" items="${users}"> 
 	<tr>
    	<td><lable>${user.getFirstName()}</lable></td>
    	<td><lable>${user.getLastName()}</lable></td>
    <tr>
	</c:forEach>
	<tr>
		<td colspan="2">
			<a href="add">Add a user</a>
		</td>
	</tr>
 </table>
 	
 
 
	
	
</body>
</html>