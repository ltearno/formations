package fr.lteconsulting.formations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( "/messages" )
@SuppressWarnings( "serial" )
public class MessagesServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		List<String> messages = recupererListeMessageSession( req.getSession() );

		//String raz = req.getParameter( "raz" );
		//if( "true".equals( raz ) )
		//	messages.clear();

		//resp.setContentType( "text/html" );
		/*resp.getWriter().print( "<html><head></head><body>"
				+ "<form method='post'>"
				+ "    <input type='text' name='" + Constantes.FORM_MESSAGE_FIELD_NAME + "'/>"
				+ "    <button>OK</button>"
				+ "</form>" );*/

		if( messages == null || messages.isEmpty() )
		{
			Vues.afficherEmptyMessage( req, resp );
		}
		else
		{
			Vues.afficherMessages( messages, req, resp );
		}

		//resp.getWriter().print( "<a href='?raz=true'>RAZ</a>" );
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		List<String> messages = recupererListeMessageSession( req.getSession() );

		String message = req.getParameter( Constantes.FORM_MESSAGE_FIELD_NAME );

		messages.add( message );

		resp.sendRedirect( "messages" );
	}

	@SuppressWarnings( "unchecked" )
	private List<String> recupererListeMessageSession( HttpSession session )
	{
		List<String> messages = (List<String>) session.getAttribute( Constantes.SESSION_MESSAGES_KEY );

		if( messages == null )
		{
			messages = new ArrayList<>();
			session.setAttribute( Constantes.SESSION_MESSAGES_KEY, messages );
		}

		return messages;
	}
}
