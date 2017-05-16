package fr.lteconsulting.formations;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Angular2GwtFilter
 */
@WebFilter( "/" )
public class Angular2GwtFilter implements Filter
{
	private Set<String> servedStaticFiles = new HashSet<>();

	public Angular2GwtFilter()
	{
		servedStaticFiles.add( "/Reflect.js" );
		servedStaticFiles.add( "/zone.js" );
		servedStaticFiles.add( "/angular2-all.umd.js" );
	}

	@Override
	public void init( FilterConfig filterConfig ) throws ServletException
	{
	}

	public void destroy()
	{
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
	{
		if( request instanceof HttpServletRequest )
		{
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String uri = httpRequest.getRequestURI();

			int lastSlashIndex = uri.lastIndexOf( "/" );
			if( lastSlashIndex >= 0 )
			{
				String requestedFile = uri.substring( lastSlashIndex );
				if( servedStaticFiles.contains( requestedFile ) )
				{
					InputStream resource = getClass().getClassLoader().getResourceAsStream( "/static" + requestedFile );

					response.setContentType( "text/javascript" );
					response.setCharacterEncoding( "UTF-8" );

					pipe( resource, response.getOutputStream() );

					return;
				}
			}
		}

		chain.doFilter( request, response );
	}

	private void pipe( InputStream is, OutputStream os ) throws IOException
	{
		int n;
		byte[] buffer = new byte[1024];
		while( (n = is.read( buffer )) > -1 )
			os.write( buffer, 0, n );
		os.close();
		is.close();
	}
}
