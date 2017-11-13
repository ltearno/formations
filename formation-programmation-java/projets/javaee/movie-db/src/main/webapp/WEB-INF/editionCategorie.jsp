<%@ page import="fr.lteconsulting.training.moviedb.model.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Categorie categorie = (Categorie) request.getAttribute("categorie");
%>

<h1>Edition</h1>

<form method="post">
    <input type="hidden" name="id" value="<%=categorie.getId()!=null?categorie.getId():"" %>">
    <label>Nom: <input type="text" name="nom" value="<%=categorie.getNom()%>" autofocus></label>
    <button>Valider</button>
</form>