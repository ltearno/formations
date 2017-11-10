package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vues
{
	public static void afficherChifoumi( String message, int scoreA, int scoreB, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		req.setAttribute( "message", message );
		req.setAttribute( "scoreA", scoreA );
		req.setAttribute( "scoreB", scoreB );
		req.getRequestDispatcher( "/WEB-INF/chifoumi.jsp" ).forward( req, resp );
	}
}
