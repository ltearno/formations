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

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
    @Inject
    private GestionUtilisateur gestionUtilisateur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Vues.afficherInscription(req, resp, "Bienvenue");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");

        Utilisateur existant = gestionUtilisateur.findByLogin(login);
        if (existant != null) {
            Vues.afficherInscription(req, resp, "Impossible avec ce login, il existe déjà !");
            return;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setPassword(password);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);

        gestionUtilisateur.add(utilisateur);
        Session.setUtilisateurConnecte(req.getSession(), utilisateur);

        resp.sendRedirect("produits");
    }
}
