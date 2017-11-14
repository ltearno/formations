package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.model.Categorie;
import fr.lteconsulting.training.moviedb.model.Fabricant;
import fr.lteconsulting.training.moviedb.outil.Vues;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editionFabricant")
public class EditionFabricantServlet extends HttpServlet {
    @EJB
    private GestionFabricants gestionFabricants;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Fabricant fabricant = null;

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            fabricant = gestionFabricants.findById(id);
            if (fabricant == null) {
                resp.sendRedirect("fabricants");
                return;
            }
        } catch (Exception e) {
            fabricant = new Fabricant();
            fabricant.setNom("Nouveau fabricant");
            fabricant.setAdresse("Toulouse");
        }

        Vues.afficherEditionFabricant(req, resp, fabricant);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Fabricant fabricant = new Fabricant();

        try {
            fabricant.setId(Integer.parseInt(req.getParameter("id")));
        } catch (Exception e) {
        }

        fabricant.setNom(req.getParameter("nom"));
        fabricant.setAdresse(req.getParameter("adresse"));

        gestionFabricants.update(fabricant);

        resp.sendRedirect("fabricants");
    }
}
