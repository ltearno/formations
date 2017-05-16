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
import fr.lteconsulting.Piece;
import fr.lteconsulting.dao.PartieDao;

@WebServlet( "/jouerCoup" )
public class JouerCoupServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private PartieDao partieDao;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String identifiantPartie = request.getParameter( "id" );
		Partie partie = partieDao.getPartie( identifiantPartie );

		Joueur joueurConnecte = DonneesScope.getJoueurSession( request );
		if( joueurConnecte == null )
		{
			redirigerAccueil( response );
			return;
		}

		int x = Integer.parseInt( request.getParameter( "x" ) );
		int y = Integer.parseInt( request.getParameter( "y" ) );

		partie.getPlateau().placerPiece( new Piece( joueurConnecte.getCharacter() ), x, y );

		partieDao.updatePartie( partie );

		redirigerReferer( request, response );
	}
}
