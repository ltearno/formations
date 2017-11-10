<%@ page import="fr.lteconsulting.training.moviedb.model.Produit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Produits</title>
    <link rel="stylesheet" href="Skeleton-2.0.4/css/normalize.css">
    <link rel="stylesheet" href="Skeleton-2.0.4/css/skeleton.css">
</head>
<body>

<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>

<h1>Recherche</h1>
<form>
    <label>Recherche dans les produits : <input type="text" name="search"></label>
    <button>Cherche</button>
</form>

<h1>Produits</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Catégorie</th>
        <th>Fabricant</th>
        <th>Actions</th>
    </tr>
    <%
        for (Produit produit : produits) {
    %>
    <tr>
        <td><%= produit.getId() %>
        </td>
        <td><%= produit.getNom()%>
        </td>
        <td><%= produit.getCategorie().getNom()%>
        </td>
        <td><%= produit.getFabricant().getNom()%>
        </td>
        <td>
            <form method="get" action="editionProduit" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= produit.getId()%>">
                <button>éditer</button>
            </form>

            <form method="post" action="suppressionProduit" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= produit.getId()%>">
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
            <form method="get" action="editionProduit">
                <button>ajouter</button>
            </form>
        </td>
        <td></td>
    </tr>
</table>

</body>
</html>
