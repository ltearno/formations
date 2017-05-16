package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.CarteDao;
import fr.lteconsulting.model.Carte;
import fr.lteconsulting.servlet.Rendu;

public class EditCarteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	CarteDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Carte carte = null;
		String titre;

		if( request.getParameter( "ID" ) != null )
		{
			String id = request.getParameter( "ID" );

			carte = dao.getCarte( id );
			if( carte == null )
			{
				response.sendRedirect( "home" );
				return;
			}

			titre = "Edition Carte " + carte.getNom();
		}
		else
		{
			carte = new Carte( "Nouvelle carte", "#000" );
			titre = "Création d'une carte";
		}

		request.setAttribute( "carte", carte );
		Rendu.pagePrincipale( titre, "/WEB-INF/editCarte.jsp", getServletContext(), request, response );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String id = request.getParameter( "ID" );
		String nom = request.getParameter( "NOM" );
		String couleur = request.getParameter( "COULEUR" );

		boolean ajout = id == null;

		Carte carte;
		if( ajout )
			carte = new Carte();
		else
			carte = dao.getCarte( id );

		carte.setNom( nom );
		carte.setCouleur( couleur );

		if( ajout )
			dao.ajouterCarte( carte );
		else
			dao.sauverCarte( carte );

		response.sendRedirect( "cartes" );
	}
}
