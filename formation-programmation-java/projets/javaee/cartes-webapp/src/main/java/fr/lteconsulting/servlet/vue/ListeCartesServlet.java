package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.CarteDao;
import fr.lteconsulting.model.Carte;
import fr.lteconsulting.servlet.Rendu;

public class ListeCartesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	CarteDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String nomUtilisateur = (String) request.getSession().getAttribute( "nom" );
		if( nomUtilisateur == null )
		{
			response.sendRedirect( "home" );
			return;
		}

		List<Carte> cartes = dao.getCartes();

		Rendu.listeCartes( "Liste des cartes à jouer", cartes, true, true, getServletContext(), request, response );
	}
}
