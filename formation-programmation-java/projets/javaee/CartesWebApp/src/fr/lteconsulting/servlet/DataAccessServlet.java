package fr.lteconsulting.servlet;

import javax.servlet.http.HttpServlet;

import fr.lteconsulting.IApplicationData;

public abstract class DataAccessServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected IApplicationData getData()
	{
		return DataAccess.get( getServletContext() );
	}
}
