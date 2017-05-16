<%@page import="fr.lteconsulting.Constantes"%>
<%@page import="fr.lteconsulting.Carte"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	pageContext.setAttribute( "NB_MAX_CARTES_PAR_MAIN", Constantes.NB_MAX_CARTES_PAR_MAIN );
%>

<div class="row">
	<c:forEach items="${requestScope['cartes']}" var="carte">
		<div class="col l3 s12">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<div class="activator valign-wrapper" style="height:17em; background-color:${carte.couleur};">
						<h5 class="valign white-text center-align" style="width: 100%;">${carte.nom}</h5>
					</div>
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">${carte.nom}<i class="material-icons right">more_vert</i></span>

					<c:if test="${montrerActionsMain}">
						<c:choose>
							<c:when test="${empty main or not main.contains(carte.id) and (main.size() < NB_MAX_CARTES_PAR_MAIN)}">
								<a style="position: relative; top: -2.5em;" class="right btn-floating btn-small waves-effect waves-light teal" href="toggleCarte?id=${carte.id}"><i
									class="material-icons">add</i></a>
							</c:when>
							<c:when test="${main.contains(carte.id)}">
								<a style="position: relative; top: -2.5em;" class="right btn-floating btn-small waves-effect waves-light red" href="toggleCarte?id=${carte.id}"><i
									class="material-icons">remove</i></a>
							</c:when>
						</c:choose>
					</c:if>

					<p>
						<a class="activator" href="#">détails de la carte</a>
					</p>
				</div>
				<c:if test="${montrerActionsCarte}">
					<div class="card-action">
						<a href="deleteCarte?id=${carte.id}">RETIRER</a>
						<a href="editCarte?ID=${carte.id}">EDITER</a>
					</div>
				</c:if>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">${carte.nom}, détails<i class="material-icons right">close</i></span>
					<p>Voici les principaux attributs de cette carte.</p>
					<table>
						<thead>
							<tr>
								<th data-field="name">Attribut</th>
								<th data-field="valeur">Valeur</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>ID</td>
								<td>${carte.id}</td>
							</tr>
							<tr>
								<td>Nom</td>
								<td>${carte.nom}</td>
							</tr>
							<tr>
								<td>Couleur</td>
								<td>${carte.couleur}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>
</div>