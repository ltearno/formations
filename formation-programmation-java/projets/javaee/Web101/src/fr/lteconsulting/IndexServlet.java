package fr.lteconsulting;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet( "/index.html" )
public class IndexServlet extends HttpServlet
{

	String sha1Digest( byte[] bytes )
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance( "SHA-1" );
			byte[] hash = digest.digest( bytes );

			StringBuilder hashString = new StringBuilder();
			for( int i = 0; i < hash.length; i++ )
			{
				String hex = Integer.toHexString( hash[i] );
				if( hex.length() == 1 )
				{
					hashString.append( '0' );
					hashString.append( hex.charAt( hex.length() - 1 ) );
				}
				else
					hashString.append( hex.substring( hex.length() - 2 ) );
			}
			
			return hashString.toString();
		}
		catch( NoSuchAlgorithmException e )
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		doRequest( request, response );
	}

	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		doRequest( request, response );
	}

	protected void doRequest( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// executer un traitement et
		// passer des informations destinées à la vue JSP
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute( "A" );
		request.setAttribute( "message", "" );

		if( "logout".equals( request.getParameter( "action" ) ) )
		{
			request.getSession().invalidate();
			utilisateur = null;

			request.setAttribute( "message", "Vous êtes maintenant déconnecté" );
		}

		if( utilisateur == null )
		{
			String paramNomUtilisateur = request.getParameter( Constantes.LOGIN_FORM_LAST_NAME_PARAMETER_NAME );
			String paramPrenomUtilisateur = request.getParameter( Constantes.LOGIN_FORM_FIRST_NAME_PARAMETER_NAME );
			if( paramNomUtilisateur == null || paramNomUtilisateur.isEmpty() || paramPrenomUtilisateur == null || paramPrenomUtilisateur.isEmpty() )
			{
				ViewHelper.displayLoginView( request, response );
				return;
			}

			utilisateur = new Utilisateur( paramPrenomUtilisateur, paramNomUtilisateur, new Date() );

			request.getSession().setAttribute( "A", utilisateur );
		}

		ViewHelper.displayWelcomeView( utilisateur, utilisateur.getLastConnectionDate(), request, response );
	}
}
