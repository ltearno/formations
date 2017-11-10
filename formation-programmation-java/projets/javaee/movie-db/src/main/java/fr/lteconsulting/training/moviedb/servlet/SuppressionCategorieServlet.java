package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionCategories;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suppressionCategorie")
public class SuppressionCategorieServlet extends HttpServlet {
    @EJB
    private GestionCategories gestionCategories;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            gestionCategories.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("categories");
    }
}
