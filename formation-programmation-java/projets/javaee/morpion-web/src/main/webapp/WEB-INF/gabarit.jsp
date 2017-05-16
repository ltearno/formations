<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:if test="${pageReload}">
	<meta http-equiv="refresh" content="5">
</c:if>

<title>${pageTitle}</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="milligram.min.css">
<link rel="stylesheet" href="morpion.css">
</head>

<body>
	<jsp:include page="entete.jsp" />

	<c:if test="${pageContentJsp!=null}">
		<div class="container">
			<jsp:include page="${pageContentJsp}" />
		</div>
	</c:if>
</body>

</html>