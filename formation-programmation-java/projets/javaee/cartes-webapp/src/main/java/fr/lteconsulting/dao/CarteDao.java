package fr.lteconsulting.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.lteconsulting.model.Carte;

@Stateless
public class CarteDao
{
	@PersistenceContext( name = "Cartes" )
	EntityManager em;

	public List<Carte> getCartes()
	{
		@SuppressWarnings( "unchecked" )
		List<Carte> result = em.createQuery( "from Carte c" ).getResultList();
		return result;
	}

	public void ajouterCarte( Carte carte )
	{
		em.persist( carte );
	}

	public void sauverCarte( Carte carte )
	{
		em.merge( carte );
	}

	public void removeCarte( String id )
	{
		em.remove( em.find( Carte.class, id ) );
	}

	public Carte getCarte( String id )
	{
		return em.find( Carte.class, id );
	}
}
