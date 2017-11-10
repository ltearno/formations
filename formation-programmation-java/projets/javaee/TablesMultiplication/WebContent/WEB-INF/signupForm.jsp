<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
Enregistrez-vous

<%
	String message = (String) request.getAttribute( "message" );
	if( message != null ) {
		%><h3><%=message%></h3><%
	}
%>

<form method='post'>
	<label for='pseudo'>Pseudo</label><input id='pseudo' name='pseudo' placeholder='Votre pseudo'/><br/>
	<label for='password'>Mot de passe</label><input type='password' id='password' name='password' placeholder='Votre mot de passe'/><br/>
	<label for='prenom'>Prénom</label><input id='prenom' name='firstName' placeholder='Votre prénom'/><br/>
	<label for='nom'>Nom</label><input id='nom' name='lastName' placeholder='Votre nom'/><br/>
	
	<button>S'enregistrer</button>
</form>