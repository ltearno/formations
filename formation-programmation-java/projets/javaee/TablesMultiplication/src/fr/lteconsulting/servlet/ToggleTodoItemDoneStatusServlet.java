package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.model.ApplicationData;

@WebServlet( "/toggleTodoListItemDoneState" )
public class ToggleTodoItemDoneStatusServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String itemNo = req.getParameter( "itemNo" );
		if( itemNo != null && !itemNo.isEmpty() )
		{
			try
			{
				int index = Integer.parseInt( itemNo );
				ApplicationData.toggleTodoListItemDoneState( index, req );
			}
			catch( NumberFormatException e )
			{
				e.printStackTrace();
			}
		}

		resp.sendRedirect( "todolist" );
	}
}
