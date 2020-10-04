<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add New User</title>
</head>
<body>
	<h2>User Register</h2>
	<form:form method="POST" modelAttribute="user" action="addUser">
	   <table>
		    <tr>
		        <td><form:label path="firstName">First Name:</form:label></td>
		        <td><form:input path="firstName" /><form:errors path="firstName"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="lastName">Last Name:</form:label></td>
		        <td><form:input path="lastName" /><form:errors path="lastName"/></td>
		    </tr>
		     <tr>
		        <td><form:label path="gender">Gender:</form:label></td>
		     	<td><form:radiobutton value="1" path="gender" /><form:errors path="gender"/>Male
		     		<form:radiobutton value="0" path="gender" /><form:errors path="gender"/>Female
		     	</td> 
		     	
		    </tr>
		     <tr>
		        <td><form:label path="phone">Phone Number:</form:label></td>
		        <td><form:input path="phone" /><form:errors path="phone"/></td>
		    </tr>
		     <tr>
		        <td><form:label path="email">Email:</form:label></td>
		        <td><form:input path="email" /><form:errors path="email"/></td>
		    </tr>
		     <tr>
		        <td><form:label path="username">User Name:</form:label></td>
		        <td><form:input path="username" /><form:errors path="username"/></td>
		    </tr>
		     <tr>
		        <td><form:label path="password">Password:</form:label></td>
		        <td><form:password path="password" /><form:errors path="password"/></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>  
	    <br/>
	    <form:errors path="*"/>
	</form:form>
</body>
</html>