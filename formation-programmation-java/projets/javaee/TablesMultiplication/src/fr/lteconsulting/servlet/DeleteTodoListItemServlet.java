package fr.lteconsulting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.model.ApplicationData;

@WebServlet( "/deleteTodoListItem" )
public class DeleteTodoListItemServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		String deleteItemNo = req.getParameter( "itemNo" );
		if( deleteItemNo != null && !deleteItemNo.isEmpty() )
		{
			try
			{
				int deleteItemNoInt = Integer.parseInt( deleteItemNo );
				ApplicationData.removeTodoListItem( deleteItemNoInt, req );
			}
			catch( NumberFormatException e )
			{
				e.printStackTrace();
			}
		}
		
		resp.sendRedirect( "todolist" );
	}
}
