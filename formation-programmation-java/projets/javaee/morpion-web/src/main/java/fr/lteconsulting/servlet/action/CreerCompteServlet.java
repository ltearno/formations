package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.dao.JoueurDao;

@WebServlet( "/creerCompte" )
public class CreerCompteServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private JoueurDao joueurDao;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// reçoit les informations de l'utilisateur
		String pseudo = request.getParameter( "pseudo" );
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );
		String passwordConfirm = request.getParameter( "password_confirm" );
		String character = request.getParameter( "character" );

		// vérifications
		if( password.equals( passwordConfirm ) && joueurDao.findJoueurByLogin( login ) == null )
		{
			// inscrire le joueur dans la liste des joueurs connus de l'application
			Joueur joueur = new Joueur( pseudo, login, password, character.charAt( 0 ) );

			// persister le joueur en BDD
			joueurDao.ajouterJoueur( joueur );

			// connecter le joueur
			DonneesScope.setJoueurSession( joueur, request );

			response.sendRedirect( "index.html" );
		}
		else
		{
			redirigerReferer( request, response );
		}
	}
}
