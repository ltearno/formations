package fr.lteconsulting.training.appengine.servlet;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.UserServiceFactory;
import fr.lteconsulting.training.appengine.RuntimeInfo;
import fr.lteconsulting.training.appengine.store.UserProfileHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Provides some data for the index.jsp page
 */
public class ApplicationServlet extends HttpServlet
{
	@Override protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Entity userProfileEntity = UserProfileHelper.ensureUserProfileEntity();

		String logoutUrl = UserServiceFactory.getUserService().createLogoutURL( "/index.html" );
		String pseudo = (String) userProfileEntity.getProperty( "pseudo" );
		String info = RuntimeInfo.getInfo();

		request.setAttribute( "logoutUrl", logoutUrl );
		request.setAttribute( "pseudo", pseudo );
		request.setAttribute( "info", info );

		request.getRequestDispatcher( "/WEB-INF/jsp/index.jsp" ).forward( request, response );
	}
}
