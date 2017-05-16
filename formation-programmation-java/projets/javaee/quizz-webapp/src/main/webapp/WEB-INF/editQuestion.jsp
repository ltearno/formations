<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>Ajout d'une question...</h1>
<form method="post">
	Question:
	<textarea name="question" cols="50" rows="10"></textarea>
	<br />

	<%
		for( int i = 1; i <= 4; i++ )
		{
	%>
	Réponse
	<%=i%>: <input type="checkbox" name="valideReponse<%=i%>" value="yes" size="80" /> <input type="text" name="reponse<%=i%>" /> <br />
	<%
		}
	%>

	<button type="submit">OK</button>
</form>