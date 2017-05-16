package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.servlet.Rendu;

public class InscriptionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		Rendu.pagePrincipale( "Inscription", "/WEB-INF/inscription.jsp", getServletContext(), req, resp );
	}
}
