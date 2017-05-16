package fr.lteconsulting.outil;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Outils
{
	public static void callJsp( String name, ServletContext context, HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		context
				.getRequestDispatcher( "/WEB-INF/" + name + ".jsp" )
				.forward( request, response );
	}
}
