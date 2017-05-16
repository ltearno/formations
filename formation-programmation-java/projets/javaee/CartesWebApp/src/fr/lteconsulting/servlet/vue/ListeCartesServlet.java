package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.servlet.DataAccessServlet;
import fr.lteconsulting.servlet.Rendu;

public class ListeCartesServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String nomUtilisateur = (String) request.getSession().getAttribute( "nom" );
		if( nomUtilisateur == null )
		{
			response.sendRedirect( "home" );
			return;
		}

		Rendu.listeCartes( "Liste des cartes à jouer", getData().getCartes(), true, true, getServletContext(), request, response );
	}
}
