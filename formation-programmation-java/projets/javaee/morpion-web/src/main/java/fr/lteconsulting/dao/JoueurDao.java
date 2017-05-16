package fr.lteconsulting.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.lteconsulting.Joueur;

@Stateless
public class JoueurDao
{
	@PersistenceContext( unitName = "Morpion" )
	private EntityManager em;

	public void ajouterJoueur( Joueur joueur )
	{
		em.persist( joueur );
	}

	public Joueur findJoueurByLogin( String login )
	{
		try
		{
			TypedQuery<Joueur> query = em.createQuery( "from Joueur j where j.login=:login", Joueur.class );
			query.setParameter( "login", login );

			return query.getSingleResult();
		}
		catch( NoResultException e )
		{
			return null;
		}
	}

	public Joueur findJoueurByLoginPassword( String login, String password )
	{
		try
		{
			TypedQuery<Joueur> query = em.createQuery( "from Joueur j where j.login=:login and password=:password", Joueur.class );
			query.setParameter( "login", login );
			query.setParameter( "password", password );

			return query.getSingleResult();
		}
		catch( NoResultException e )
		{
			return null;
		}
	}
}
