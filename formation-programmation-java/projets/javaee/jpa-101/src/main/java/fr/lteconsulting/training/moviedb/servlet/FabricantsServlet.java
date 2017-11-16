package fr.lteconsulting.training.moviedb.servlet;

import fr.lteconsulting.training.moviedb.ejb.GestionFabricants;
import fr.lteconsulting.training.moviedb.model.Fabricant;
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

@WebServlet("/fabricants")
public class FabricantsServlet extends HttpServlet {
    @EJB
    private GestionFabricants gestionFabricants;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!Session.estConnecte(req)) {
            resp.sendRedirect("login");
            return;
        }

        List<Fabricant> fabricants = gestionFabricants.findAll();

        Map<Integer, Long> nbProduitsParFabricant = new HashMap<>();
        for (Fabricant fabricant : fabricants) {
            nbProduitsParFabricant.put(fabricant.getId(), gestionFabricants.getNbProduitParFabricantId(fabricant.getId()));
        }

        Vues.afficherFabricants(req, resp, fabricants, nbProduitsParFabricant);
    }
}
