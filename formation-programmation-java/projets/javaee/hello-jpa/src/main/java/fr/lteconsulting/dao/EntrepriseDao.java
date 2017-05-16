package fr.lteconsulting.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.lteconsulting.model.Entreprise;

@Stateless
public class EntrepriseDao
{
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings( "unchecked" )
	public List<Entreprise> getEntreprises()
	{
		Query query = em.createQuery( "from Entreprise" );
		return query.getResultList();
	}

	public void add( Entreprise entreprise )
	{
		em.persist( entreprise );
	}
}



