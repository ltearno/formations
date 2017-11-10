package fr.lteconsulting.formations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/session" )
public class SessionServlet extends HttpServlet
{
	Map<String, Map<String, Object>> sessions = new HashMap<>();

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		if( "true".equals( req.getParameter( "raz" ) ) )
			clearSession( req );

		Integer compteur = (Integer) getSession( req, resp ).get( "compteur" );
		if( compteur == null )
			compteur = 0;
		compteur++;
		getSession( req, resp ).put( "compteur", compteur );

		resp.setContentType( "text/html" );
		resp.getWriter().print( "<html><body>"
				+ "compteur : " + compteur
				+ "</body></html>" );
	}

	private void clearSession( HttpServletRequest req )
	{
		String cookieValue = getSopraCookieValue( req );
		if( cookieValue != null )
			sessions.remove( cookieValue );
	}

	private Map<String, Object> getSession( HttpServletRequest req, HttpServletResponse resp )
	{
		// est-ce que on a le cookie SOPRA_COOKIE ?
		String cookieValue = getSopraCookieValue( req );

		Map<String, Object> session = null;
		if( cookieValue != null )
			session = sessions.get( cookieValue );

		// si j'ai pas trouvé de session j'en crée une et je l'enregistre
		if( session == null )
		{
			cookieValue = UUID.randomUUID().toString();
			session = new HashMap<>();
			sessions.put( cookieValue, session );
			resp.addCookie( new Cookie( "SOPRA_COOKIE", cookieValue ) );
		}

		return session;
	}

	private String getSopraCookieValue( HttpServletRequest req )
	{
		Cookie[] cookies = req.getCookies();
		if( cookies == null )
			return null;

		for( Cookie cookie : cookies )
			if( "SOPRA_COOKIE".equals( cookie.getName() ) )
				return cookie.getValue();

		return null;
	}
}
