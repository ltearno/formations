package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.CarteDao;
import fr.lteconsulting.model.Carte;
import fr.lteconsulting.servlet.Rendu;

public class MainServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	CarteDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		List<Carte> cartes = new ArrayList<>();

		@SuppressWarnings( "unchecked" )
		Set<String> main = (Set<String>) request.getSession().getAttribute( "main" );
		if( main != null )
		{
			for( String id : main )
				cartes.add( dao.getCarte( id ) );
		}

		Rendu.listeCartes( "Cartes dans votre main", cartes, true, false, getServletContext(), request, response );
	}
}
