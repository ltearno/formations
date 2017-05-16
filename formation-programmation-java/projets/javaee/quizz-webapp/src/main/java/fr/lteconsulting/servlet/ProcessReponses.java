package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.BigDao;

public class ProcessReponses extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	BigDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		dao.updateReponses();

		response.getWriter().println( "ok" );
	}
}
