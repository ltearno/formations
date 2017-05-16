package fr.lteconsulting.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.lteconsulting.model.Utilisateur;

@Stateless
public class UtilisateurDao
{
	@PersistenceContext( name = "Cartes" )
	EntityManager em;

	public List<Utilisateur> getUtilisateurs()
	{
		@SuppressWarnings( "unchecked" )
		List<Utilisateur> result = (List<Utilisateur>) em.createQuery( "from Utilisateur" ).getResultList();
		return result;
	}

	public void add( Utilisateur utilisateur )
	{
		em.persist( utilisateur );
	}

	public void save( Utilisateur utilisateur )
	{
		em.merge( utilisateur );
	}

	public void delete( int id )
	{
		em.remove( em.find( Utilisateur.class, id ) );
	}

	public Utilisateur login( String login, String motDePasse )
	{
		Query query = em.createQuery( "from Utilisateur u where u.login=:login and u.motDePasse=:motDePasse" );
		query.setParameter( "login", login );
		query.setParameter( "motDePasse", motDePasse );

		try
		{
			Utilisateur u = (Utilisateur) query.getSingleResult();
			return u;
		}
		catch( NoResultException e )
		{
			return null;
		}
	}

	public Utilisateur trouverUtilisateurParLogin( String login )
	{
		Query query = em.createQuery( "from Utilisateur u where u.login=:login" );
		query.setParameter( "login", login );

		try
		{
			Utilisateur u = (Utilisateur) query.getSingleResult();
			return u;
		}
		catch( NoResultException e )
		{
			return null;
		}
	}
}