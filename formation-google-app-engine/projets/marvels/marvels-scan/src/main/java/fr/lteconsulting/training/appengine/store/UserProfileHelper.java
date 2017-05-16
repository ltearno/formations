package fr.lteconsulting.training.appengine.store;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class UserProfileHelper
{
	/**
	 * Ensures a UserProfileEntity exists for the logged user
	 */
	public static Entity ensureUserProfileEntity()
	{
		User user = UserServiceFactory.getUserService().getCurrentUser();

		Key userProfileEntityKey = userProfileEntityKey( user );

		DatastoreService store = DatastoreServiceFactory.getDatastoreService();
		Transaction tx = store.beginTransaction();
		try
		{
			return store.get( userProfileEntityKey );
		}
		catch( EntityNotFoundException e )
		{
			Entity userProfileEntity = new Entity( userProfileEntityKey );

			userProfileEntity.setProperty( "email", user.getEmail() );
			store.put( userProfileEntity );

			return userProfileEntity;
		}
		finally
		{
			tx.commit();
		}
	}

	/**
	 * Returns the key of the entity for storinig the profile associated to a given user
	 *
	 * @param user
	 * @return
	 */
	public static Key userProfileEntityKey( User user )
	{
		Key userProfileEntityKey = KeyFactory.createKey( "UserProfile", user.getUserId() );

		return userProfileEntityKey;
	}
}
