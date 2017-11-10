package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.model.ApplicationData;

@WebServlet( "/addTodoListItem" )
public class AddTodoListItemServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String item = req.getParameter( "item" );
		if( item != null && !item.trim().isEmpty() )
			ApplicationData.addTodoListItem( item, req );

		resp.sendRedirect( "todolist" );
	}
}
