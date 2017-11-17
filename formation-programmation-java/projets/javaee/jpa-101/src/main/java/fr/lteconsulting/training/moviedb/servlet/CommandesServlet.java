package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCommande;
import fr.lteconsulting.training.moviedb.model.Commande;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/commandes")
public class CommandesServlet extends HttpServlet {
    @Inject
    private GestionCommande gestionCommande;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Commande> commandes = gestionCommande.findAll();

        Vues.afficherCommandes(req, resp, commandes);
    }
}
