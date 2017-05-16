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

@WebServlet( "/creerPartie" )
public class CreerPartieServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private PartieDao partieDao;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String nomPartie = request.getParameter( "nomPartie" );
		int taillePlateau = Integer.parseInt( request.getParameter( "taillePlateau" ) );

		Partie partie = new Partie( nomPartie, taillePlateau );

		Joueur joueur = DonneesScope.getJoueurSession( request );

		partie.ajouterJoueur( joueur );

		partieDao.ajouterPartie( partie );

		redirigerPartie( partie, response );
	}
}
