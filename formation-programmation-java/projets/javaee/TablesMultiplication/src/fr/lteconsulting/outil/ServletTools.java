package fr.lteconsulting.outil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTools
{
	public static void afficherPage( String pageTitle, String jspName, HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		req.setAttribute( "pageTitle", pageTitle );
		req.setAttribute( "bodyJspFile", jspName + ".jsp" );
		
		req.getRequestDispatcher( "WEB-INF/pageTemplate.jsp" ).forward( req, resp );
	}
}
