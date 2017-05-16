<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav>
	<div class="nav-wrapper">
		<a href="#" class="brand-logo">${pageTitle}</a>
		<ul id="nav-mobile" class="right hide-on-med-and-down">
			<li><a href="home">Accueil</a></li>
			<c:if test="${not empty utilisateur}">
				<li><a href="logout">Se déconnecter</a></li>
			</c:if>
			<c:if test="${empty utilisateur }">
				<li><a href="inscription">S'inscrire</a></li>
			</c:if>
		</ul>
	</div>
</nav>