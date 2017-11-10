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

@WebServlet( "/login" )
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String pseudo = req.getParameter( "pseudo" );
		String password = req.getParameter( "password" );

		if( pseudo != null && !pseudo.isEmpty() && pseudo != null && !pseudo.isEmpty() )
		{
			// on cherche un utilisateur avec ce pseudo et ce mot de passe dans notre base d'utilisateurs
			List<User> users = ApplicationData.getUserDatabase( req );
			for( User user : users )
			{
				if( user.getPseudo().equals( pseudo ) && user.getPassword().equals( password ) )
				{
					ApplicationData.setConnectedUser( req, user );
					break;
				}
			}
		}

		resp.sendRedirect( "welcome" );
	}
}
