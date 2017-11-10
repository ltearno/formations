<%@ page import="fr.lteconsulting.training.moviedb.model.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Categories</title>
    <link rel="stylesheet" href="Skeleton-2.0.4/css/normalize.css">
    <link rel="stylesheet" href="Skeleton-2.0.4/css/skeleton.css">
</head>
<body>

<%
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
    Map<Integer, Long> nbProduitsParCategorie = (Map<Integer, Long>) request.getAttribute("nbProduitsParCategorie");
%>

<h1>Catégories</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Nombre de produits</th>
        <th>Actions</th>
    </tr>
    <%
        for (Categorie categorie : categories) {
    %>
    <tr>
        <td><%= categorie.getId() %>
        </td>
        <td><%= categorie.getNom()%>
        </td>
        <td><%= nbProduitsParCategorie.get(categorie.getId())%>
        </td>
        <td>
            <form method="get" action="editionCategorie" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= categorie.getId()%>">
                <button>éditer</button>
            </form>

            <form method="post" action="suppressionCategorie" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= categorie.getId()%>">
                <button>supprimer</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>

    <tr>
        <td></td>
        <td>
            <form method="get" action="editionCategorie">
                <button>ajouter</button>
            </form>
        </td>
        <td></td>
    </tr>
</table>

</body>
</html>
