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
	<div class="form">
		<img class="logo" src="../resources/images/emusic3.png" alt="logo">
		<h2>User Login</h2>
	
		<form:form method="POST" modelAttribute="user"
			action="userLogin">
			<table >
				<form:hidden path="firstName" value="Default" />
				<form:hidden path="lastName" value="Default" />
				<form:hidden path="email" value="default@default.com" />
				<form:hidden path="phone" value="1234567890" />
				<tr>
					<td><form:label class="label-form" path="username" >Username</form:label></td>
				</tr>
				<tr>
					<td><form:input class="input-form" path="username" placeholder="Enter username" /></td>
				</tr>
				<tr>
					<td><form:label class="label-form" path="password">Password</form:label></td>
				</tr>
				<tr>
					<td><form:password class="input-form" path="password" placeholder="Enter password" /></td>
				</tr>
				<tr class="align_login_button">
					<td colspan="2"><input class="button" type="submit"
						value="Login" />
						<div>
							<a href="../user/add">Sign up</a>
						</div></td>
				
				</tr>
				<tr><td><form:errors path="*" /></td></tr>
			</table>
			<br />
		</form:form>
	</div>
</body>

</html>