<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
	String contentJsp = (String) request.getAttribute( "contentJsp" );
	String pageTitle = (String) request.getAttribute( "pageTitle" );
	if( pageTitle == null )
		pageTitle = "Cartes";
%>

<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/styles/vs.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.5.0/highlight.min.js"></script>

<!-- Materialize -->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title><%= pageTitle %></title>
</head>

<body>
	<%@ include file="navigation.jsp"%>

	<% if( contentJsp != null ) { %>
	<div class="container">
		<jsp:include page="<%=contentJsp%>" />
	</div>
	<% } %>

	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	<script>hljs.initHighlightingOnLoad();</script>
</body>
</html>