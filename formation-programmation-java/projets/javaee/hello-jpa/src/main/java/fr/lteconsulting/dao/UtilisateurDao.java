package fr.lteconsulting.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.lteconsulting.model.Utilisateur;

@Stateless
public class UtilisateurDao
{
	@PersistenceContext( name = "HelloJpa" )
	private EntityManager em;

	@SuppressWarnings( "unchecked" )
	public List<Utilisateur> getUtilisateurs()
	{
		Query query = em.createQuery( "from Utilisateur" );
		return query.getResultList();
	}

	public void addUtilisateur( Utilisateur utilisateur )
	{
		em.persist( utilisateur );
	}

	public Utilisateur getUtilisateur( int id )
	{
		return em.find( Utilisateur.class, id );
	}

	public void removeUtilisateur( Utilisateur utilisateur )
	{
		utilisateur = em.merge( utilisateur );
		em.remove( utilisateur );
	}

	public void updateUtilisateur( Utilisateur utilisateur )
	{
		em.merge( utilisateur );
	}
}
