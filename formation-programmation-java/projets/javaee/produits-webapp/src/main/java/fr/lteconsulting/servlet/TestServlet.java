package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.ProduitDao;

@WebServlet( "/test" )
public class TestServlet extends HttpServlet
{
	@EJB
	private ProduitDao produitDao;

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String id = req.getParameter( "id" );
		if( id == null )
			produitDao.creerProduit();
		else
			produitDao.removeProduit( Integer.parseInt( id ) );

		doGet( req, resp );
	}

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException
	{
		req.setAttribute( "produits", produitDao.getProduits() );
		req.getRequestDispatcher( "/WEB-INF/produits.jsp" ).forward( req, resp );
	}
}
