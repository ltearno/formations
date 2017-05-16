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

@WebServlet( "/login" )
public class LoginServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private JoueurDao joueurDao;

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// extraire les parametres de la requete
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );

		// on va vérifier si le joueur s'est bien authentifié
		// on parcours la liste des joueurs en cherchant un joueur qui correspond
		// aux informations données dans la requête par l'utilisateur
		Joueur joueur = joueurDao.findJoueurByLoginPassword( login, password );
		if( joueur != null )
			DonneesScope.setJoueurSession( joueur, request );

		redirigerReferer( request, response );
	}
}
