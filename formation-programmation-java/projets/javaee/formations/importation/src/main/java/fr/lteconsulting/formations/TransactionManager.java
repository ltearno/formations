package fr.lteconsulting.formations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransactionManager
{
	private EntityManagerFactory emf;

	public interface TransactionExecutor<T>
	{
		T execute( EntityManager em );
	}

	public TransactionManager( String persistenceUnitName )
	{
		emf = Persistence.createEntityManagerFactory( persistenceUnitName );
	}

	public void close()
	{
		if( emf == null )
			throw new RuntimeException( "EntityManagerFactory is already closed!" );

		emf.close();
		emf = null;
	}

	public <T> T withinTransaction( TransactionExecutor<T> executor )
	{
		if( emf == null )
			throw new RuntimeException( "EntityManagerFactory has been closed, no TX can begin!" );

		EntityManager em = emf.createEntityManager();

		try
		{
			em.getTransaction().begin();

			T result = executor.execute( em );

			em.getTransaction().commit();

			return result;
		}
		catch( Exception e )
		{
			em.getTransaction().rollback();
			throw new RuntimeException( e );
		}
		finally
		{
			em.close();
		}
	}
}
