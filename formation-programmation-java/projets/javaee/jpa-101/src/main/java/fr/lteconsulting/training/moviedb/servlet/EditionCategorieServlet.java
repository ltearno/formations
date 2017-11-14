package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.outil.Vues;
import fr.lteconsulting.training.moviedb.model.Categorie;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editionCategorie")
public class EditionCategorieServlet extends HttpServlet {
    @EJB
    private GestionCategories gestionCategories;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Categorie categorie = null;

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            categorie = gestionCategories.findById(id);
            if (categorie == null) {
                resp.sendRedirect("categories");
                return;
            }
        } catch (Exception e) {
            categorie = new Categorie();
            categorie.setNom("Nouvelle catégorie");
        }

        Vues.afficherEditionCategorie(req, resp, categorie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Categorie categorie = new Categorie();

        try {
            categorie.setId(Integer.parseInt(req.getParameter("id")));
        } catch (Exception e) {
        }

        categorie.setNom(req.getParameter("nom"));

        gestionCategories.update(categorie);

        resp.sendRedirect("categories");
    }
}
