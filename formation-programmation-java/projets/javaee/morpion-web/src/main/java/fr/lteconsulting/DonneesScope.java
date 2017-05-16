package fr.lteconsulting;

import javax.servlet.http.HttpServletRequest;

public class DonneesScope
{
	private static final String JOUEUR_SESSION_ATTRIBUTE_NAME = "joueur";

	public static Joueur getJoueurSession( HttpServletRequest request )
	{
		return (Joueur) request.getSession().getAttribute( JOUEUR_SESSION_ATTRIBUTE_NAME );
	}

	public static void setJoueurSession( Joueur joueur, HttpServletRequest request )
	{
		request.getSession().setAttribute( JOUEUR_SESSION_ATTRIBUTE_NAME, joueur );
	}

	public static void viderSession( HttpServletRequest request )
	{
		request.getSession().invalidate();
	}
}
