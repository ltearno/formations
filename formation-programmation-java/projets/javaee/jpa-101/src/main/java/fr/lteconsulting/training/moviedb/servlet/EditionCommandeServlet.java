package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCommande;
import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.model.Commande;
import fr.lteconsulting.training.moviedb.outil.Session;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editionCommande")
public class EditionCommandeServlet extends HttpServlet {
    @Inject
    private GestionCommande gestionCommandes;

    @Inject
    private GestionProduits gestionProduits;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande commande = null;

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            commande = gestionCommandes.findById(id);
            if (commande == null) {
                resp.sendRedirect("commandes");
                return;
            }
        } catch (Exception e) {
            commande = new Commande();
            commande.setQuantite(1);
        }

        Vues.afficherEditionCommande(req, resp, commande, gestionProduits.findAll(), "Saisissez votre commande");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande commande = new Commande();
        try {
            commande.setId(Integer.parseInt(req.getParameter("id")));
        } catch (Exception e) {
        }

        commande.setCreateur(Session.getUtilisateurConnecte(req.getSession()));
        commande.setQuantite(Integer.parseInt(req.getParameter("quantite")));
        commande.setProduit(gestionProduits.findById(Integer.parseInt(req.getParameter("produitId"))));

        try {
            gestionCommandes.update(commande);
        } catch (Exception e) {
            Vues.afficherEditionCommande(req, resp, commande, gestionProduits.findAll(), "Commande erronée : " + e.getMessage());
        }

        resp.sendRedirect("commandes");
    }
}
