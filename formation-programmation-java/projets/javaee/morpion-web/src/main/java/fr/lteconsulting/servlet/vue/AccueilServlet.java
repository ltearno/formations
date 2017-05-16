package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.dao.PartieDao;

@WebServlet( "/index.html" )
public class AccueilServlet extends VueServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private PartieDao partieDao;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		Joueur joueur = DonneesScope.getJoueurSession( req );
		if( joueur != null )
		{
			List<Partie> parties = partieDao.getParties();

			vueAccueil( joueur, parties, req, resp );
		}
		else
		{
			vueLogin( req, resp );
		}
	}
}
