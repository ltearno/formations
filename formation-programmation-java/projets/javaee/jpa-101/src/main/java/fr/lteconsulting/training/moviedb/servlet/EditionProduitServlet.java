package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.model.Produit;
import fr.lteconsulting.training.moviedb.outil.Session;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editionProduit")
public class EditionProduitServlet extends HttpServlet {
    @EJB
    private GestionProduits gestionProduits;

    @EJB
    private GestionCategories gestionCategories;

    @EJB
    private GestionFabricants gestionFabricants;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produit produit = null;

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            produit = gestionProduits.findById(id);
            if (produit == null) {
                resp.sendRedirect("produits");
                return;
            }
        } catch (Exception e) {
            produit = new Produit();
            produit.setNom("Nouveau produit");
        }

        Vues.afficherEditionProduit(req, resp, produit, gestionCategories.findAll(), gestionFabricants.findAll());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produit produit = new Produit();

        try {
            produit.setId(Integer.parseInt(req.getParameter("id")));
        } catch (Exception e) {
        }

        produit.setNom(req.getParameter("nom"));
        produit.setCategorie(gestionCategories.findById(Integer.parseInt(req.getParameter("categorieId"))));
        produit.setFabricant(gestionFabricants.findById(Integer.parseInt(req.getParameter("fabricantId"))));

        gestionProduits.update(produit);

        resp.sendRedirect("produits");
    }
}
