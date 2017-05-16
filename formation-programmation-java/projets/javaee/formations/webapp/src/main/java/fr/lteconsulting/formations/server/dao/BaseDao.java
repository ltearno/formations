package fr.lteconsulting.formations.server.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;

public class BaseDao
{
	public final <T> List<T> getAll( EntityManager em, Class<T> clazz )
	{
		return em.createQuery( "from " + clazz.getName() + " o", clazz ).getResultList();
	}

	public final <T> T getById( EntityManager em, Class<T> clazz, int id )
	{
		return em.find( clazz, id );
	}

	public final <T> T createOrUpdate( EntityManager em, Class<T> clazz, T record )
	{
		if( getRecordId( clazz, record ) == null )
		{
			em.persist( record );
			return record;
		}

		return em.merge( record );
	}

	public final void delete( EntityManager em, Class<?> clazz, int id )
	{
		Object entity = getById( em, clazz, id );
		if( entity != null )
			em.remove( entity );
	}

	private <T> Integer getRecordId( Class<T> clazz, T record )
	{
		Method idGetterMethod = getIdGetterMethod( clazz );

		try
		{
			return (Integer) idGetterMethod.invoke( record );
		}
		catch( IllegalAccessException | IllegalArgumentException | InvocationTargetException e )
		{
			e.printStackTrace();
			throw new RuntimeException( "Cannot find the identifier getter method on entity class " + clazz.getName(), e );
		}
	}

	private Method getIdGetterMethod( Class<?> clazz )
	{
		try
		{
			return clazz.getMethod( "getId" );
		}
		catch( NoSuchMethodException | SecurityException e )
		{
			e.printStackTrace();
			return null;
		}
	}
}
