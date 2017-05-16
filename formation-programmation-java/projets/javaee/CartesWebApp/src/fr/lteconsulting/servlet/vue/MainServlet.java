package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Carte;
import fr.lteconsulting.servlet.DataAccessServlet;
import fr.lteconsulting.servlet.Rendu;

public class MainServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		List<Carte> cartes = new ArrayList<>();

		@SuppressWarnings( "unchecked" )
		Set<String> main = (Set<String>) request.getSession().getAttribute( "main" );
		if( main != null )
		{
			for( String id : main )
				cartes.add( getData().getCarte( id ) );
		}

		Rendu.listeCartes( "Cartes dans votre main", cartes, true, false, getServletContext(), request, response );
	}
}
