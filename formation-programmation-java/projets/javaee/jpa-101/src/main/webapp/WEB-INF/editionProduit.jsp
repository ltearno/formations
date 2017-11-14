<%@ page import="fr.lteconsulting.training.moviedb.model.Categorie" %>
<%@ page import="fr.lteconsulting.training.moviedb.model.Fabricant" %>
<%@ page import="fr.lteconsulting.training.moviedb.model.Produit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Produit produit = (Produit) request.getAttribute("produit");
    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
    List<Fabricant> fabricants = (List<Fabricant>) request.getAttribute("fabricants");

    int selectedCategorieId = produit.getCategorie() != null ? produit.getCategorie().getId() : -1;
    int selectedFabricantId = produit.getFabricant() != null ? produit.getFabricant().getId() : -1;
%>

<h1>Edition</h1>

<form method="post">
    <input type="hidden" name="id" value="<%=produit.getId()!=null?produit.getId():"" %>">
    <label>Nom: <input type="text" name="nom" value="<%=produit.getNom()%>" autofocus></label>
    <label>Catégorie : <select name="categorieId">
        <% for (Categorie categorie : categories) {
        %>
        <option value="<%= categorie.getId()%>" <%= categorie.getId() == selectedCategorieId ? "selected" : "" %>><%= categorie.getNom()%>
        </option>
        <%
            }%>
    </select></label>
    <label>Fabricant : <select name="fabricantId">
        <% for (Fabricant fabricant : fabricants) {
        %>
        <option value="<%= fabricant.getId()%>" <%= fabricant.getId() == selectedFabricantId ? "selected" : "" %>><%= fabricant.getNom()%>
        </option>
        <%
            }%>
    </select></label>
    <button>Valider</button>
</form>