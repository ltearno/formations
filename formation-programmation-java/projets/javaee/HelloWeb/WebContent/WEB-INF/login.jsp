<%@page import="fr.lteconsulting.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1>Merci de vous identifier</H1>

	<form method="post">
		<label for="name">Nom :</label>
		
		<input type="text" id="name" name="<%= Constantes.REQUEST_PARAMETER_USER_NAME %>" /> <br />

		<button type="submit">Valider</button>
	</form>

</body>
</html>