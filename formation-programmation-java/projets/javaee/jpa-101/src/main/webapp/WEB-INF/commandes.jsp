<%@ page import="fr.lteconsulting.training.moviedb.model.Commande" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
%>

<h1>Commandes</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Créateur</th>
        <th>Produit</th>
        <th>Date dernière modification</th>
        <th>Quantité</th>
    </tr>
    <%
        for (Commande commande : commandes) {
    %>
    <tr>
        <td><%= commande.getId() %>
        </td>
        <td><%= commande.getCreateur().getNom()%>
        </td>
        <td><%= commande.getProduit().getNom()%>
        </td>
        <td><%= commande.getLastUpdateDate() %>
        </td>
        <td><%= commande.getQuantite() %>
        </td>
        <td>
            <form method="get" action="editionCommande" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= commande.getId()%>">
                <button>éditer</button>
            </form>

            <form method="post" action="suppressionCommande" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= commande.getId()%>">
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
            <form method="get" action="editionCommande">
                <button>ajouter</button>
            </form>
        </td>
        <td></td>
    </tr>
</table>