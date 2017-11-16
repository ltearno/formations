package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.model.Fabricant;
import fr.lteconsulting.training.moviedb.model.Produit;
import fr.lteconsulting.training.moviedb.outil.ExportExcel;
import fr.lteconsulting.training.moviedb.outil.Session;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/export.xls")
public class ExportServlet extends HttpServlet {
    private static final String FILENAME = "export.xls";

    @EJB
    private GestionCategories gestionCategories;

    @EJB
    private GestionFabricants gestionFabricants;

    @EJB
    private GestionProduits gestionProduits;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-disposition", "attachment; filename=" + FILENAME);
        resp.setHeader("content-type", "application/xls");

        ExportExcel export = new ExportExcel();

        export.line("Export de la base de données Movie-DB");

        export.line();
        export.line("Catégories");
        export.line("ID", "Nom");
        for (Categorie categorie : gestionCategories.findAll())
            export.line(categorie.getId(), categorie.getNom());

        export.line();
        export.line("Fabricants");
        export.line("ID", "Nom", "Adresse");
        for (Fabricant fabricant : gestionFabricants.findAll())
            export.line(fabricant.getId(), fabricant.getNom(), fabricant.getAdresse());

        export.line();
        export.line("Produits");
        export.line("ID", "ID_Catégorie", "Catégorie", "ID_Fabricant", "Fabricant", "Nom");
        for (Produit produit : gestionProduits.findAll())
            export.line(produit.getId(),
                    produit.getCategorie() != null ? produit.getCategorie().getId() : "",
                    produit.getCategorie() != null ? produit.getCategorie().getNom() : "",
                    produit.getFabricant() != null ? produit.getFabricant().getId() : "",
                    produit.getFabricant() != null ? produit.getFabricant().getNom() : "",
                    produit.getNom());

        export.write(resp.getOutputStream());
    }
}