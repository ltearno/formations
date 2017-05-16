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
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );

		if( email != null && !email.isEmpty() && password != null && !password.isEmpty() )
		{
			Utilisateur utilisateur = utilisateurDao.login( email, password );
			if( utilisateur != null )
			{
				Tools.connecterUtilisateur( utilisateur, request.getSession() );
			}
		}

		response.sendRedirect( "home" );
	}
}
