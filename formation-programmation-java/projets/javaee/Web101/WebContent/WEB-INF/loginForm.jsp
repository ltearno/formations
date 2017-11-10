<%@page import="fr.lteconsulting.Constantes"%>
<%@page import="fr.lteconsulting.CookieHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connection</title>

</head>
<body>
	<h2><%= request.getAttribute( "message" ) %></h2>

	<form method='POST'>
		<input type="text" name="<%= Constantes.LOGIN_FORM_LAST_NAME_PARAMETER_NAME %>" /><br />
		<input type="text" name="<%= Constantes.LOGIN_FORM_FIRST_NAME_PARAMETER_NAME %>" />
		<button type="submit">SE CONNECTER</button>
	</form>
</body>
</html>