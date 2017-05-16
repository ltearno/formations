package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Carte;
import fr.lteconsulting.servlet.DataAccessServlet;
import fr.lteconsulting.servlet.Rendu;

public class EditCarteServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Carte carte = null;
		String titre;

		if( request.getParameter( "ID" ) != null )
		{
			String id = request.getParameter( "ID" );

			carte = getData().getCarte( id );
			if( carte == null )
			{
				response.sendRedirect( "home" );
				return;
			}

			titre = "Edition Carte";
		}
		else
		{
			carte = new Carte( "Pas de nom", "#000" );
			titre = "Nouvelle carte";
		}

		request.setAttribute( "carte", carte );
		Rendu.pagePrincipale( titre, "/WEB-INF/editCarte.jsp", getServletContext(), request, response );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Carte carte = getData().getCarte( request.getParameter( "ID" ) );
		if( carte == null )
		{
			// Si on ne trouve pas la carte, c'est que l'on est en train de l'ajouter !
			carte = new Carte( "", "" );
			getData().ajouterCarte( carte );
		}

		carte.setNom( request.getParameter( "NOM" ) );
		carte.setCouleur( request.getParameter( "COULEUR" ) );

		response.sendRedirect( "cartes" );
	}
}
