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
	@PersistenceContext( name = "Quizz" )
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

	public Utilisateur login( String email, String motDePasse )
	{
		Query query = em.createQuery( "from Utilisateur u where u.email=:email and u.password=:password" );
		query.setParameter( "email", email );
		query.setParameter( "password", motDePasse );

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

	public Utilisateur trouverUtilisateurParEmail( String email )
	{
		Query query = em.createQuery( "from Utilisateur u where u.email=:email" );
		query.setParameter( "email", email );

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