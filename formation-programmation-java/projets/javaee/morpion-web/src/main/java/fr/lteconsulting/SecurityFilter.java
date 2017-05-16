package fr.lteconsulting;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter( "/*" )
public class SecurityFilter implements Filter
{
	private List<String> authorizedUrls;

	public void init( FilterConfig filterConfig ) throws ServletException
	{
		String contextPath = filterConfig.getServletContext().getContextPath();

		authorizedUrls = Arrays.asList(
				contextPath + "/morpion.css",
				contextPath + "/milligram.min.css",
				contextPath + "/normalize.css",
				contextPath + "/jquery-3.1.1.js",
				contextPath + "/crud-contacts.html",
				contextPath + "/index.html",
				contextPath + "/creationCompte.html",
				contextPath + "/login",
				contextPath + "/creerCompte",
				contextPath + "/contacts",
				contextPath + "/api/contacts" );
	}

	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
			throws IOException, ServletException
	{
		// traitement du filtre
		if( request instanceof HttpServletRequest )
		{
			HttpServletRequest httpRequest = (HttpServletRequest) request;

			Joueur joueurConnecte = DonneesScope.getJoueurSession( httpRequest );
			if( joueurConnecte == null )
			{
				String uri = httpRequest.getRequestURI();
				if( !authorizedUrls.contains( uri ) )
				{
					HttpServletResponse httpResponse = (HttpServletResponse) response;
					httpResponse.sendRedirect( "index.html" );
					return;
				}
			}
		}

		// passage de la requête au filtre ou servlet suivant
		chain.doFilter( request, response );
	}

	public void destroy()
	{
	}
}
