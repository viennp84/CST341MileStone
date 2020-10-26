<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add New Genre</title>
</head>
<body>
	<div class="form">
		<h2>Create Genre</h2>
		<form:form method="POST" modelAttribute="genre" action="addGenre">
			<table>
				<tr>
					<td><form:label class="label-form" path="name">Genre:</form:label></td>
					<td><form:input class="input-form" path="name" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Create" /></td>
				</tr>
			</table>
			<br />
			<form:errors path="*" />
		</form:form>
	</div>
</body>
</html>