package fr.lteconsulting.training.appengine.servlet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import fr.lteconsulting.training.appengine.store.UserProfileHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles the registration form used by the user to populate its pseudo.
 */
public class RegistrationServlet extends HttpServlet
{
	@Override protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Entity userProfileEntity = UserProfileHelper.ensureUserProfileEntity();
		request.setAttribute( "pseudo", userProfileEntity.getProperty( "pseudo" ) );

		request.getRequestDispatcher( "/WEB-INF/jsp/registration.jsp" ).forward( request, response );
	}

	@Override protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		Entity userProfileEntity = UserProfileHelper.ensureUserProfileEntity();

		userProfileEntity.setProperty( "pseudo", req.getParameter( "pseudo" ) );

		DatastoreService store = DatastoreServiceFactory.getDatastoreService();

		store.put( userProfileEntity );

		req.getRequestDispatcher( "/WEB-INF/jsp/index.jsp" ).forward( req, resp );
	}
}
