<%@ page import="fr.lteconsulting.training.moviedb.model.Fabricant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Fabricant> fabricants = (List<Fabricant>) request.getAttribute("fabricants");
    Map<Integer, Long> nbProduitsParFabricant = (Map<Integer, Long>) request.getAttribute("nbProduitsParFabricant");
%>

<h1>Fabricants</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Adresse</th>
        <th>Nombre de produit</th>
        <th>Actions</th>
    </tr>
    <%
        for (Fabricant fabricant : fabricants) {
    %>
    <tr>
        <td><%= fabricant.getId() %>
        </td>
        <td><%= fabricant.getNom()%>
        </td>
        <td><%= fabricant.getAdresse()%>
        </td>
        <td><%= nbProduitsParFabricant.get(fabricant.getId())%>
        </td>
        <td>
            <form method="get" action="editionFabricant" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= fabricant.getId()%>">
                <button>éditer</button>
            </form>

            <form method="post" action="suppressionFabricant" style="display: inline-block;">
                <input type="hidden" name="id" value="<%= fabricant.getId()%>">
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
            <form method="get" action="editionFabricant">
                <button>ajouter</button>
            </form>
        </td>
        <td></td>
    </tr>
</table>