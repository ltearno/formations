package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.model.ApplicationData;
import fr.lteconsulting.outil.ServletTools;

@WebServlet( "/todolist" )
public class TodoListServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		if( ApplicationData.getConnectedUser( req ) == null )
		{
			resp.sendRedirect( "welcome" );
			return;
		}

		req.setAttribute( "todoList", ApplicationData.getTodoList( req ) );

		ServletTools.afficherPage( "Gestion de la liste", "todolist", req, resp );
	}
}
