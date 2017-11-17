package fr.lteconsulting.training.moviedb.outil;

import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.model.Commande;
import fr.lteconsulting.training.moviedb.model.Fabricant;
import fr.lteconsulting.training.moviedb.model.Produit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Vues {
    public static void afficherLogin(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        req.setAttribute("message", message);

        afficherPage(req, resp, "Connexion", "login");
    }

    public static void afficherInscription(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        req.setAttribute("message", message);

        afficherPage(req, resp, "Inscription", "inscription");
    }

    public static void afficherCategories(HttpServletRequest req, HttpServletResponse resp, List<Categorie> categories, Map<Integer, Long> nbProduitsParCategorie) throws ServletException, IOException {
        req.setAttribute("categories", categories);
        req.setAttribute("nbProduitsParCategorie", nbProduitsParCategorie);

        afficherPage(req, resp, "Visualisation des catégories", "categories");
    }

    public static void afficherEditionCategorie(HttpServletRequest req, HttpServletResponse resp, Categorie categorie) throws ServletException, IOException {
        req.setAttribute("categorie", categorie);

        afficherPage(req, resp, "Edition catégorie", "editionCategorie");
    }

    public static void afficherFabricants(HttpServletRequest req, HttpServletResponse resp, List<Fabricant> fabricants, Map<Integer, Long> nbProduitsParFabricant) throws ServletException, IOException {
        req.setAttribute("fabricants", fabricants);
        req.setAttribute("nbProduitsParFabricant", nbProduitsParFabricant);

        afficherPage(req, resp, "Visualisation fabricants", "fabricants");
    }

    public static void afficherEditionFabricant(HttpServletRequest req, HttpServletResponse resp, Fabricant fabricant) throws ServletException, IOException {
        req.setAttribute("fabricant", fabricant);

        afficherPage(req, resp, "Edition fabricant", "editionFabricant");
    }

    public static void afficherProduits(HttpServletRequest req, HttpServletResponse resp, List<Produit> produits) throws ServletException, IOException {
        req.setAttribute("produits", produits);

        afficherPage(req, resp, "Visualisation des produits", "produits");
    }

    public static void afficherEditionProduit(HttpServletRequest req, HttpServletResponse resp, Produit produit, List<Categorie> categories, List<Fabricant> fabricants) throws ServletException, IOException {
        req.setAttribute("produit", produit);
        req.setAttribute("categories", categories);
        req.setAttribute("fabricants", fabricants);

        afficherPage(req, resp, "Edition produit", "editionProduit");
    }

    public static void afficherResultatImportation(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        req.setAttribute("message", message);

        afficherPage(req, resp, "Résultat importation", "resultatImportation");
    }

    public static void afficherCommandes(HttpServletRequest req, HttpServletResponse resp, List<Commande> commandes) throws ServletException, IOException {
        req.setAttribute("commandes", commandes);

        afficherPage(req, resp, "Liste des commandes", "commandes");
    }

    public static void afficherEditionCommande(HttpServletRequest req, HttpServletResponse resp, Commande commande, List<Produit> produits, String message) throws ServletException, IOException {
        req.setAttribute("commande", commande);
        req.setAttribute("produits", produits);
        req.setAttribute("message", message);

        afficherPage(req, resp, "Edition commande", "editionCommande");
    }

    public static void afficherPage(HttpServletRequest req, HttpServletResponse resp, String title, String pageToDisplay) throws ServletException, IOException {
        req.setAttribute("title", title);
        req.setAttribute("pageToDisplay", pageToDisplay + ".jsp");

        req.getRequestDispatcher("/WEB-INF/basePage.jsp").forward(req, resp);
    }
}
