package fr.lteconsulting.formations;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/index.html" )
@SuppressWarnings( "serial" )
public class ChifoumiServlet extends HttpServlet
{
	private static final String SESSION_ETAT_KEY = Constantes.COUP_PARAMETER;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		EtatChifoumi etat = recupereOuCreeEtatChifoumi( req.getSession() );

		Vues.afficherChifoumi( "Choisis un coup", etat.getScoreJoueur(), etat.getScoreOrdinateur(), req, resp );
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		try
		{
			Coup coupJoueur = Coup.valueOf( req.getParameter( Constantes.COUP_PARAMETER ) );
			Coup coupOrdinateur = Coup.values()[new Random().nextInt( Coup.values().length )];

			EtatChifoumi etat = recupereOuCreeEtatChifoumi( req.getSession() );

			String message = coupJoueur + " contre " + coupOrdinateur + " : ";

			int comparison = coupJoueur.battle( coupOrdinateur );
			if( comparison < 0 )
			{
				etat.incrementeOrdinateur();
				message += "Perdu";
			}
			else if( comparison > 0 )
			{
				etat.incrementeJoueur();
				message += "Gagné";
			}
			else
			{
				message += "Egalité !";
			}

			Vues.afficherChifoumi( message, etat.getScoreJoueur(), etat.getScoreOrdinateur(), req, resp );
		}
		catch( Exception e )
		{
			resp.sendRedirect( "index.html" );
		}
	}

	private EtatChifoumi recupereOuCreeEtatChifoumi( HttpSession session )
	{
		EtatChifoumi etat = (EtatChifoumi) session.getAttribute( SESSION_ETAT_KEY );
		if( etat == null )
		{
			etat = new EtatChifoumi();
			session.setAttribute( SESSION_ETAT_KEY, etat );
		}

		return etat;
	}
}
