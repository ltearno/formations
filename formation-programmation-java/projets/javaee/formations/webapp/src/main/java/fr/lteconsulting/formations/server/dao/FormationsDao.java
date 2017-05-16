package fr.lteconsulting.formations.server.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.lteconsulting.formations.model.Formation;

@Stateless
public class FormationsDao
{
	@PersistenceContext( name = "formations" )
	EntityManager em;

	public List<Formation> getAll()
	{
		return em.createQuery( "from Formation f", Formation.class ).getResultList();
	}

	public Formation getById( int id )
	{
		return em.find( Formation.class, id );
	}

	public Formation createOrUpdate( Formation formation )
	{
		if( formation.getId() == null )
		{
			em.persist( formation );
			return formation;
		}

		return em.merge( formation );
	}

	public void delete( int id )
	{
		em.remove( getById( id ) );
	}

	public List<Formation> findByIntitule( String term )
	{
		return em.createQuery( "from Formation f where lower(f.intitule) like :term", Formation.class )
				.setParameter( "term", "%" + term.toLowerCase() + "%" )
				.getResultList();
	}
}
