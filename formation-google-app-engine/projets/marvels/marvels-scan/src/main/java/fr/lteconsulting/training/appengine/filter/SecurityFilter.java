package fr.lteconsulting.training.appengine.filter;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import fr.lteconsulting.training.appengine.store.UserProfileHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Provides a minimal security mechanism
 */
public class SecurityFilter implements Filter
{
	@Override public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
	{
		// pass-through for App Engine managed requests and tasks requests
		String accessedUrl = ((HttpServletRequest) request).getRequestURI();
		if( accessedUrl.startsWith( "/_ah/" ) || accessedUrl.startsWith( "/tasks/" ) )
		{
			chain.doFilter( request, response );
			return;
		}

		// ensure that the user is logged in
		UserService userService = UserServiceFactory.getUserService();
		if( !userService.isUserLoggedIn() )
		{
			request.getRequestDispatcher( "/WEB-INF/jsp/login.jsp" ).forward( request, response );
			return;
		}

		// ensure we have a user profile entity
		Entity userProfileEntity = UserProfileHelper.ensureUserProfileEntity();

		// ensure user pseudo is stored in the profile entity
		if( userProfileEntity.getProperty( "pseudo" ) == null && !"/registration".equals( accessedUrl ) )
		{
			request.getRequestDispatcher( "/WEB-INF/jsp/registration.jsp" ).forward( request, response );
			return;
		}

		// let the http request be processed normally
		chain.doFilter( request, response );
	}

	@Override public void init( FilterConfig filterConfig ) throws ServletException
	{
	}

	@Override public void destroy()
	{
	}
}
