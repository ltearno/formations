<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	Todo List - ${titre}
	
	<c:choose>
		<c:when test="${connectedUser != null}">
			${connectedUser.firstName} ${connectedUser.lastName}
		</c:when>
		<c:otherwise>Non connecté !</c:otherwise>
	</c:choose>
</nav>