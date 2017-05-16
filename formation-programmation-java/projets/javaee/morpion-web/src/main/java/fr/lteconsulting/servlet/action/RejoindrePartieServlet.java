package fr.lteconsulting.servlet.action;

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

@WebServlet( "/rejoindrePartie" )
public class RejoindrePartieServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private PartieDao partieDao;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String identifiantPartie = request.getParameter( "partie" );

		Partie partie = partieDao.getPartie( identifiantPartie );
		if( partie != null )
		{
			Joueur joueurConnecte = DonneesScope.getJoueurSession( request );
			partie.ajouterJoueur( joueurConnecte );

			partieDao.updatePartie( partie );

			redirigerPartie( partie, response );
		}
		else
		{
			redirigerAccueil( response );
		}
	}
}
