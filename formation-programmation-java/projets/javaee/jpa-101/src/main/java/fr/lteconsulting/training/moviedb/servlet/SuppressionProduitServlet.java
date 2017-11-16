package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionProduits;
import fr.lteconsulting.training.moviedb.outil.Session;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suppressionProduit")
public class SuppressionProduitServlet extends HttpServlet {
    @EJB
    private GestionProduits gestionProduits;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            gestionProduits.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("produits");
    }
}
