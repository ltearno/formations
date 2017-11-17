<%@ page import="fr.lteconsulting.training.moviedb.model.Commande" %>
<%@ page import="fr.lteconsulting.training.moviedb.model.Produit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Commande commande = (Commande) request.getAttribute("commande");
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");

    int selectedProduitId = commande.getProduit() != null ? commande.getProduit().getId() : -1;
%>

<h1>Entrez votre commande</h1>

<h2>${message}</h2>

<form method="post">
    <input type="hidden" name="id" value="<%=commande.getId()!=null?commande.getId():"" %>">
    <label>Quantité: <input type="text" name="quantite" value="<%=commande.getQuantite()%>" autofocus></label>
    <label>Produit : <select name="produitId">
        <% for (Produit produit : produits) {
        %>
        <option value="<%= produit.getId()%>" <%= produit.getId() == selectedProduitId ? "selected" : "" %>><%= produit.getNom()%>
        </option>
        <%
            }%>
    </select></label>
    <button>Valider</button>
</form>