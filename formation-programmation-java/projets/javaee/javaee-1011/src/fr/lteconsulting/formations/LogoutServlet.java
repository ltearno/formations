package fr.lteconsulting.formations;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/logout" )
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		doGet(req,resp);
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		// vider la session
		req.getSession().invalidate();

		// rediriger vers hello-session.html
		resp.sendRedirect( "hello-session.html" );
	}
}
