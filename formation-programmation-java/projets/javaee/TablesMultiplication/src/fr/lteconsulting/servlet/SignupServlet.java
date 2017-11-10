package fr.lteconsulting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.model.ApplicationData;
import fr.lteconsulting.model.User;
import fr.lteconsulting.outil.ServletTools;

@WebServlet( "/signup" )
public class SignupServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		if( req.getParameter( "alreadyExist" ) != null )
			req.setAttribute( "message", "Ce pseudo est déjà utilisé, faites preuve de plus d'imagination !" );

		ServletTools.afficherPage( "Enregistrement utilisateur", "signupForm", req, resp );
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String pseudo = req.getParameter( "pseudo" );
		String password = req.getParameter( "password" );
		String firstName = req.getParameter( "firstName" );
		String lastName = req.getParameter( "lastName" );

		List<User> users = ApplicationData.getUserDatabase( req );
		for( User user : users )
		{
			if( user.getPseudo().equals( pseudo ) )
			{
				// le pseudo est déjà utilisé, on redirige simplement vers ce même formulaire d'inscription
				// il faudrait donner un message d'erreur à l'utilisateur...
				resp.sendRedirect( "signup?alreadyExist=yes" );
				return;
			}
		}

		// si on arrive ici, c'est qu'aucun user n'est déjà enregistré avec ce pseudo

		// on l'ajoute à la base des Users
		User user = new User( pseudo, password, firstName, lastName );
		users.add( user );

		// et on l'enregistre en session
		ApplicationData.setConnectedUser( req, user );

		resp.sendRedirect( "welcome" );
	}
}
