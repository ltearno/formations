<%@page import="fr.lteconsulting.formations.Constantes"%>
<%@page import="fr.lteconsulting.formations.Coup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chifoumi</title>
<style>
body{
	position: absolute;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	
	display: flex;
	flex-flow: column nowrap;
}

* {
	box-sizing: border-box;
	font-size: 2vh;
	font-family: sans-serif;
}

body>div {
	padding: 2em;
}

body>div:nth-child(1) {
	background-color: #eeeeee;
}

body>div:nth-child(2) {
	flex-grow: 1;
}
body>div:nth-child(3) {
	background-color: beige;
}
</style>
</head>
<body>

<%
String message = (String) request.getAttribute( "message" );
int scoreA = (Integer) request.getAttribute( "scoreA" );
int scoreB = (Integer) request.getAttribute( "scoreB" );
%>

<div>
	<%= message %>
</div>

<div>
	<% for(Coup coup:Coup.values()) { %>
	<form method='post'>
		<input type='hidden' name='<%= Constantes.COUP_PARAMETER %>' value='<%= coup %>'/>
		<button><%= coup %></button>
	</form>
	<% } %>
</div>

<div>
	Score :
	<ul>
		<li>Vous: <%= scoreA %></li>
		<li>Ordinateur: <%= scoreB %></li>
	</ul>
</div>

</body>
</html>