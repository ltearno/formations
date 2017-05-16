package fr.lteconsulting.training.appengine.servlet;

import com.google.appengine.api.datastore.*;
import fr.lteconsulting.training.appengine.model.CommentEntityWrapper;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Handles sending email tasks
 */
public class SendEmailWorkerServlet extends HttpServlet
{
	@Override protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		try
		{
			DatastoreService store = DatastoreServiceFactory.getDatastoreService();
			Key commentKey = KeyFactory.stringToKey( req.getParameter( "commentKey" ) );
			CommentEntityWrapper commentEntityWrapper = CommentEntityWrapper.from( store.get( commentKey ) );

			int marvelId = commentEntityWrapper.getMarvelId();

			Query q = new Query( CommentEntityWrapper.KIND )
					.setFilter( new Query.FilterPredicate( CommentEntityWrapper.MARVEL_ID, Query.FilterOperator.EQUAL, marvelId ) );

			Set<Key> userKeys = new HashSet<>();
			PreparedQuery pq = store.prepare( q );
			for( Entity comment : pq.asIterable() )
				userKeys.add( CommentEntityWrapper.from( comment ).getUserEntityKey() );

			Map<Key, Entity> keyEntityMap = store.get( userKeys );
			for( Map.Entry<Key, Entity> k : keyEntityMap.entrySet() )
			{
				Entity userProfileEntity = k.getValue();

				String userEmail = (String) userProfileEntity.getProperty( "email" );
				String pseudo = (String) userProfileEntity.getProperty( "pseudo" );

				if( userEmail != null && pseudo != null )
					sendEmail( userEmail, pseudo, "A new comment has been posted", "On you super MARVELlous website" );
			}
		}
		catch( Exception e )
		{
		}
	}

	@Override protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		doGet( req, resp );
	}

	private void sendEmail( String recipient, String name, String subject, String body )
	{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance( props, null );

		try
		{
			Message msg = new MimeMessage( session );
			msg.setFrom( new InternetAddress( "ltearno@gmail.com", "Marvel Scan Administrator" ) );
			msg.addRecipient( Message.RecipientType.TO,
					new InternetAddress( recipient, name ) );
			msg.setSubject( subject );
			msg.setText( body );
			Transport.send( msg );
		}
		catch( AddressException e )
		{
		}
		catch( MessagingException e )
		{
		}
		catch( UnsupportedEncodingException e )
		{
		}
	}
}
