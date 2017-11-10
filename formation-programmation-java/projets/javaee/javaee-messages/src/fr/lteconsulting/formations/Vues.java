package fr.lteconsulting.formations;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vues
{
	public static void afficherEmptyMessage( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException
	{
		req.getRequestDispatcher( "/WEB-INF/empty.jsp" ).forward( req, resp );
	}

	public static void afficherMessages( List<String> messages, HttpServletRequest req, HttpServletResponse resp ) 
			throws ServletException, IOException
	{
		req.setAttribute( "messages", messages );
		req.getRequestDispatcher( "/WEB-INF/messages.jsp" ).forward( req, resp );
	}
}
