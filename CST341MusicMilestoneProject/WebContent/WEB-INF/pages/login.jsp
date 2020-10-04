<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Welcome to eMusic, Please Login</h2>
	<form:form method="POST" modelAttribute="user" action="userLogin">
	   <table>
		    <tr>
		        <td><form:label path="username">User Name:</form:label></td>
		        <td><form:input path="username" /></td>
		    </tr>
		     <tr>
		        <td><form:label path="password">Password:</form:label></td>
		        <td><form:password path="password" /></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Login"/>
		        </td>
		    </tr>
		</table>  
	    <br/>
	</form:form>
</body>
</html>