package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.dao.PartieDao;

@WebServlet( "/partie.html" )
public class PartieServlet extends VueServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private PartieDao partieDao;

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String identifiantPartie = request.getParameter( "id" );

		Partie partie = partieDao.getPartie( identifiantPartie );
		if( partie == null )
		{
			response.sendRedirect( "index.html" );
			return;
		}

		if( partie.getJoueurs().size() < 2 )
		{
			vuePartieEnAttente( partie, request, response );
		}
		else
		{
			Joueur joueurConnecte = DonneesScope.getJoueurSession( request );

			vuePartie( joueurConnecte, partie.getPlateau(), partie, joueurConnecte.getId().equals( partie.getJoueurCourant().getId() ), request, response );
		}
	}
}
