package fr.lteconsulting;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.servlet.Rendu;

/**
 * Servlet Filter implementation class SecuriteFilter
 */
public class SecuriteFilter implements Filter
{
	private ServletContext context;

	public SecuriteFilter()
	{
	}

	public void destroy()
	{
	}

	public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain ) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();

		Set<String> accepteds = new HashSet<>();
		accepteds.add( "js/" );
		accepteds.add( "css/" );
		accepteds.add( "font/" );
		accepteds.add( "fonts/" );
		accepteds.add( "/login" );

		boolean needSecurityCheck = true;

		for( String accepted : accepteds )
		{
			if( uri.contains( accepted ) )
			{
				needSecurityCheck = false;
				break;
			}
		}

		if( needSecurityCheck )
		{
			// Je regarde l'objet associé à la clé "nom" dans la session de l'utilisateur
			String nomUtilisateur = (String) request.getSession().getAttribute( "nom" );
			if( nomUtilisateur == null )
			{
				Rendu.pageLogin( context, request, response );
				return;
			}
		}

		chain.doFilter( request, response );
	}

	public void init( FilterConfig fConfig ) throws ServletException
	{
		context = fConfig.getServletContext();
	}
}
