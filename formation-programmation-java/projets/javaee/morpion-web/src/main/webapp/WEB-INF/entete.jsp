<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav>
	<section class="container">
		<h1 class="float-left">${pageTitle}<c:if test="${joueur!=null}"> - ${joueur.pseudo}</c:if></h1>
		<ul class="float-right">
		<c:if test='${pageTitle!="Accueil"}'><li><a href="index.html">Accueil</a></li></c:if>
		<c:if test="${joueur!=null}"><li><a href="logout">Se déconnecter</a></li></c:if>
		</ul>
	</section>
</nav>