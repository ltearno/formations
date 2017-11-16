package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionUtilisateur;
import fr.lteconsulting.training.moviedb.model.Utilisateur;
import fr.lteconsulting.training.moviedb.outil.Session;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Inject
    GestionUtilisateur gestionUtilisateur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Session.estConnecte(req))
            resp.sendRedirect("produits");
        else
            Vues.afficherLogin(req, resp, "Bienvenue");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = gestionUtilisateur.login(req.getParameter("login"), req.getParameter("password"));
        if (utilisateur == null) {
            Vues.afficherLogin(req, resp, "Impossible de se connecter, réessaye");
        } else {
            Session.setUtilisateurConnecte(req.getSession(), utilisateur);
            resp.sendRedirect("produits");
        }
    }
}
