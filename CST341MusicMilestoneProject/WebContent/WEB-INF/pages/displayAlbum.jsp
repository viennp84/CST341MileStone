<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Album</title>
</head>
<body>
		<div >
		<h2>Album List</h2>
		<table id="table">
			<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>ArtistId</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>
			<c:forEach var="album" items="${albums}">
				<tr>
					<td>${album.getAlbumId()}</td>
					<td>${album.getTitle()}</td>
					<td>${album.getArtistId()}</td>
					<td class="edit">
						<a href="deleteAlbum/${album.getAlbumId()}">Delete</a>
					</td>
					<!-- <td class="edit"><input  type="submit" value="Update" /></td>  -->
					
				<tr>
			</c:forEach>
		</table>
	</div>
		
</body>

</html>