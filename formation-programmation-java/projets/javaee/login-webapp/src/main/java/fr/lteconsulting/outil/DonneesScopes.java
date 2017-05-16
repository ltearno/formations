package fr.lteconsulting.outil;

import javax.servlet.http.HttpServletRequest;

import fr.lteconsulting.User;

public class DonneesScopes
{
	public static void resetSession( HttpServletRequest request )
	{
		request.getSession().invalidate();
	}
	
	/**
	 * Returns the user registered in the session
	 */
	public static User getConnectedUser( HttpServletRequest request )
	{
		return (User) request.getSession().getAttribute( "user" );
	}

	/**
	 * Registers the user in the session
	 */
	public static void setConnectedUser( User user, HttpServletRequest request )
	{
		request.getSession().setAttribute( "user", user );
	}
}
