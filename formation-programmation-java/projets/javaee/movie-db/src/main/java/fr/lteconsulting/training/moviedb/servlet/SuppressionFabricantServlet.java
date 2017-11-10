package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/suppressionFabricant")
public class SuppressionFabricantServlet extends HttpServlet {
    @EJB
    private GestionFabricants gestionFabricants;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            gestionFabricants.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("fabricants");
    }
}
