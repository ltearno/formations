<%@ page import="fr.lteconsulting.training.moviedb.model.Fabricant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Fabricant fabricant = (Fabricant) request.getAttribute("fabricant");
%>

<h1>Edition</h1>

<form method="post">
    <input type="hidden" name="id" value="<%=fabricant.getId()!=null?fabricant.getId():"" %>">
    <label>Nom: <input type="text" name="nom" value="<%=fabricant.getNom()%>" autofocus></label>
    <label>Adresse: <input type="text" name="adresse" value="<%=fabricant.getAdresse()%>"></label>
    <button>Valider</button>
</form>