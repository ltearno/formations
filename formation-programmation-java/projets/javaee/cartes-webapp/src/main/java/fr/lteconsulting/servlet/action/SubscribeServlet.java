package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Tools;
import fr.lteconsulting.dao.UtilisateurDao;
import fr.lteconsulting.model.Utilisateur;
import fr.lteconsulting.servlet.Rendu;

/**
 * Servlet implementation class SubscribeServlet
 */
public class SubscribeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@EJB
	UtilisateurDao utilisateurDao;

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String nom = (String) request.getParameter( "nom" );
		String prenom = (String) request.getParameter( "prenom" );
		int age = Integer.parseInt( (String) request.getParameter( "age" ) );
		String login = (String) request.getParameter( "login" );
		String password = (String) request.getParameter( "password" );

		if( utilisateurDao.trouverUtilisateurParLogin( login ) != null )
		{
			Rendu.pagePrincipale( "Erreur", "/WEB-INF/erreurUtilisateurExiste.jsp", getServletContext(), request, response );
			return;
		}

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom( nom );
		utilisateur.setPrenom( prenom );
		utilisateur.setAge( age );
		utilisateur.setLogin( login );
		utilisateur.setMotDePasse( password );

		utilisateurDao.add( utilisateur );
		
		Tools.connecterUtilisateur( utilisateur, request.getSession() );

		response.sendRedirect( "home" );
	}
}
