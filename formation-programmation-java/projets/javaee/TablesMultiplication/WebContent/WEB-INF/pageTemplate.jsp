<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href="milligram.min.css">
<link rel='stylesheet' href="main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo list - ${pageTitle}</title>
</head>
<body>

<%@ include file='navigation.jsp' %>

<jsp:include page="${bodyJspFile}"></jsp:include>

</body>
</html>