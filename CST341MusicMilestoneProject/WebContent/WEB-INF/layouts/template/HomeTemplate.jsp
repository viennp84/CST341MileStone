<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/main.js" var="mainJs" />
	
	<link href="${mainCss}" rel="stylesheet" />
	<script src="${mainJs}"></script>
</head>

<body class="body">
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div>
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
</body>

</html>