package fr.lteconsulting.training.appengine.ws;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.users.UserServiceFactory;
import fr.lteconsulting.training.appengine.model.CommentEntityWrapper;
import fr.lteconsulting.training.appengine.store.UserProfileHelper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Path( "/api/marvel-metadata" )
public class MarvelCommentsWebService
{
	@GET
	@Path( "comment/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Collection<Comment> getComment( @PathParam( "id" ) int characterId )
	{
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		Query query = new Query( CommentEntityWrapper.KIND )
				.setFilter( new Query.FilterPredicate( CommentEntityWrapper.MARVEL_ID, Query.FilterOperator.EQUAL, characterId ) )
				.addSort( "date" );

		List<Entity> entities = ds.prepare( query ).asList( FetchOptions.Builder.withDefaults() );

		List<CommentEntityWrapper> commentEntities = CommentEntityWrapper.fromEntities( entities );

		List<Comment> comments = new ArrayList<>( commentEntities.size() );
		for( CommentEntityWrapper entity : commentEntities )
			comments.add( commentEntityToComment( entity ) );

		return comments;
	}

	@POST
	@Path( "comment/{id}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Comment addComment( @PathParam( "id" ) int characterId, CommentRequest request )
	{
		CommentEntityWrapper comment = new CommentEntityWrapper();
		comment.setMarvelId( characterId );
		comment.setDate( new Date() );
		comment.setContent( request.content );
		comment.setUserEntityKey( UserProfileHelper.userProfileEntityKey( UserServiceFactory.getUserService().getCurrentUser() ) );

		DatastoreService store = DatastoreServiceFactory.getDatastoreService();
		Queue queue = QueueFactory.getDefaultQueue();
		Transaction transaction = store.beginTransaction();
		store.put( comment.entity() );
		queue.add( TaskOptions.Builder
				.withUrl( "/tasks/send-email-worker" )
				.param( "commentKey", KeyFactory.keyToString( comment.entity().getKey() ) ) );
		transaction.commit();

		return commentEntityToComment( comment );
	}

	@DELETE
	@Path( "comment/{key}" )
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public boolean removeComment( @PathParam( "key" ) String commentKey )
	{
		Key key = KeyFactory.stringToKey( commentKey );
		if( key == null )
			return false;

		// ensures that only the comment author can remove its comments
		DatastoreService store = DatastoreServiceFactory.getDatastoreService();
		Transaction transaction = store.beginTransaction();
		try
		{
			CommentEntityWrapper commentEntityWrapper = CommentEntityWrapper.from( store.get( key ) );

			Key writerProfileEntityKey = commentEntityWrapper.getUserEntityKey();
			if( writerProfileEntityKey.equals( UserProfileHelper.userProfileEntityKey( UserServiceFactory.getUserService().getCurrentUser() ) ) )
				store.delete( key );
		}
		catch( EntityNotFoundException e )
		{
		}
		finally
		{
			transaction.commit();
		}

		return true;
	}

	private Comment commentEntityToComment( CommentEntityWrapper entity )
	{
		Comment comment = new Comment();
		comment.commentKey = KeyFactory.keyToString( entity.entity().getKey() );
		comment.date = entity.getDate();
		comment.content = entity.getContent();
		comment.userAlias = entity.getUserEntityKey().toString();

		// TODO optimize that !
		try
		{
			DatastoreService store = DatastoreServiceFactory.getDatastoreService();
			Key writerProfileEntityKey = entity.getUserEntityKey();
			Entity writerProfileEntity = store.get( writerProfileEntityKey );
			comment.userAlias = (String) writerProfileEntity.getProperty( "pseudo" );
			comment.isMine = writerProfileEntityKey.equals( UserProfileHelper.userProfileEntityKey( UserServiceFactory.getUserService().getCurrentUser() ) );
		}
		catch( EntityNotFoundException e )
		{
			comment.userAlias = "UNKNOWN USER";
		}

		return comment;
	}
}