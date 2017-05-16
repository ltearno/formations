package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.servlet.Rendu;

public class HomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 4623134370840447179L;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// Je regarde l'objet associé à la clé "nom" dans la session de l'utilisateur
		String nomUtilisateur = (String) req.getSession().getAttribute( "nom" );

		if( nomUtilisateur != null )
		{
			Rendu.pageBienvenue( nomUtilisateur, getServletContext(), req, resp );
		}
		else
		{
			Rendu.pageLogin( getServletContext(), req, resp );
		}
	}
}
