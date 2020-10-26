<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add New Album</title>
</head>
<body>
	<div class="form">
		<h2>Create Album</h2>
		<form:form method="POST" modelAttribute="album" action="addAlbum">
			<table>
				<tr>
					<td><form:label class="label-form" path="title">Title:</form:label></td>
					<td><form:input class="input-form" path="title" /></td>
				</tr>
				<tr>
				<td><form:label class="label-form" path="artistId">ArtistId:</form:label></td>
					<td><form:input class="input-form" path="artistId" /></td>
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