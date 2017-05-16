<%@page import="fr.lteconsulting.model.Carte"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Carte carte = (Carte) request.getAttribute( "carte" );
%>

<h2>${pageTitle}</h2>

<form method="post">
	<c:if test="${not empty carte.id}">
		<input type="hidden" name="ID" value="${carte.id}" />
	</c:if>

	<div class="input-field">
		<input id="name" type="text" class="validate" name="NOM" value="${carte.nom}"> <label for="name">Nom</label>
	</div>

	<div class="input-field">
		<input id="couleur" type="text" class="validate" name="COULEUR" value="${carte.couleur}"> <label for="couleur">Couleur</label>
	</div>

	<button class="btn waves-effect waves-light" type="submit">
		Valider <i class="material-icons right">send</i>
	</button>
</form>