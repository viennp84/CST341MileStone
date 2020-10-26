<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Artists</title>
</head>
<body>
		<div >
		<h2>Artist List</h2>
		<table id="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Artist name</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
			<c:forEach var="artist" items="${artists}">
				<tr>
					<td>${artist.getArtistId()}</td>
					<td>${artist.getArtistName()}</td>
					<td class="edit">
						<a href="deleteArtist/${artist.getArtistId()}">Delete</a>
					</td>
					<td class="edit"><a href="updateArtist/${artist.getArtistId()}">Update</a></td>
					
				<tr>
			</c:forEach>
		</table>
	</div>
		
</body>

</html>