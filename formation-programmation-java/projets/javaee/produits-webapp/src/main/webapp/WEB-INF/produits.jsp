<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<c:forEach var="produit" items="${produits}">
		<tr>
			<td>${produit.id}</td>
			<td>${produit.nom}</td>
			<td>${produit.poids}</td>
			<td>
				<form method="post">
					<input type="hidden" name="id" value="${produit.id}"/>
					<button type="submit">SUPPR</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<form method="post">
	<button type="submit">AJOUTER</button>
</form>

</body>
</html>