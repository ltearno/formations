package fr.lteconsulting.training.appengine.model;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Helper class to work with Comment entities.
 * A better idea is to use Objectify ;)
 */
public class CommentEntityWrapper
{
	public static final String KIND = "Comment";

	public static final String MARVEL_ID = "marvelId";
	public static final String USER_ENTITY_KEY = "userEntityKey";
	public static final String DATE = "date";
	public static final String CONTENT = "content";

	private final Entity entity;

	public CommentEntityWrapper()
	{
		this( new Entity( KIND ) );
	}

	private CommentEntityWrapper( Entity entity )
	{
		this.entity = entity;
	}

	public static CommentEntityWrapper from( Entity entity )
	{
		return new CommentEntityWrapper( entity );
	}

	public static List<CommentEntityWrapper> fromEntities( List<Entity> entities )
	{
		List<CommentEntityWrapper> result = new ArrayList<>( entities.size() );
		for( Entity entity : entities )
			result.add( new CommentEntityWrapper( entity ) );
		return result;
	}

	public Entity entity()
	{
		return entity;
	}

	public int getMarvelId()
	{
		// TODO test if value type is Long or Integer...
		return Integer.parseInt( "" + getProperty( MARVEL_ID ) );
	}

	public void setMarvelId( int id )
	{
		setProperty( MARVEL_ID, id );
	}

	public Key getUserEntityKey()
	{
		return getProperty( USER_ENTITY_KEY );
	}

	public void setUserEntityKey( Key key )
	{
		setProperty( USER_ENTITY_KEY, key );
	}

	public Date getDate()
	{
		return getProperty( DATE );
	}

	public void setDate( Date date )
	{
		setProperty( DATE, date );
	}

	public String getContent()
	{
		return getProperty( CONTENT );
	}

	public void setContent( String content )
	{
		setProperty( CONTENT, content );
	}

	private <T> T getProperty( String name )
	{
		return (T) entity.getProperty( name );
	}

	private void setProperty( String name, Object value )
	{
		entity.setProperty( name, value );
	}
}
