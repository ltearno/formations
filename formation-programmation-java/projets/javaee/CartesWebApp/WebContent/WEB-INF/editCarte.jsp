<%@page import="fr.lteconsulting.Carte"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Carte carte = (Carte) request.getAttribute( "carte" );
%>

<form method="post">
	<input type="hidden" name="ID" value="<%= carte.getId() %>" />

	<div class="input-field">
		<input id="name" type="text" class="validate" name="NOM" value="<%= carte.getNom() %>"> <label for="name">Nom</label>
	</div>
	
	<div class="input-field">
		<input id="couleur" type="text" class="validate" name="COULEUR" value="<%= carte.getCouleur() %>"> <label for="couleur">Couleur</label>
	</div>

	<button class="btn waves-effect waves-light" type="submit">
		Valider <i class="material-icons right">send</i>
	</button>
</form>