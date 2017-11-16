package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;
import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.outil.Session;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet {
    @EJB
    private GestionCategories gestionCategories;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> categories = gestionCategories.findAll();

        Map<Integer, Long> nbProduitsParCategorie = new HashMap<>();
        for (Categorie categorie : categories) {
            nbProduitsParCategorie.put(categorie.getId(), gestionCategories.getNbProduitParCategorieId(categorie.getId()));
        }

        Vues.afficherCategories(req, resp, categories, nbProduitsParCategorie);
    }
}
