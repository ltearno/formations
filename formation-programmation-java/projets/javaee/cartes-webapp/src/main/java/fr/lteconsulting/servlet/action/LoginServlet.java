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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	UtilisateurDao utilisateurDao;

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String login = request.getParameter( "login" );
		String password = request.getParameter( "password" );

		if( login != null && !login.isEmpty() && password != null && !password.isEmpty() )
		{
			Utilisateur utilisateur = utilisateurDao.login( login, password );
			if( utilisateur != null )
			{
				Tools.connecterUtilisateur( utilisateur, request.getSession() );
			}
		}

		response.sendRedirect( "home" );
	}
}
