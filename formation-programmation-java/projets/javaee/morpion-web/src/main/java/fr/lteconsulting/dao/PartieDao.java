package fr.lteconsulting.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;

@Stateless
public class PartieDao
{
	@PersistenceContext( unitName = "Morpion" )
	private EntityManager em;

	public List<Partie> getParties()
	{
		return em.createQuery( "from Partie", Partie.class ).getResultList();
	}

	public List<Partie> getPartiesSansJoueur( Joueur joueur )
	{
		return em
				.createQuery( "from Partie p where :joueur NOT MEMBER OF p.joueurs", Partie.class )
				.setParameter( "joueur", joueur )
				.getResultList();
	}

	public void removeVieilleParties()
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone( TimeZone.getTimeZone( "UTC-1" ) );// Paris time
		calendar.setTime( new Date() );
		calendar.add( Calendar.DATE, -5 );

		Date dateEffacement = calendar.getTime();

		System.out.println( "date effacement " + dateEffacement );

		em
				.createQuery( "delete from Partie p where p.creationDate <= :date" )
				.setParameter( "date", dateEffacement )
				.executeUpdate();
	}

	public Partie getPartie( String id )
	{
		return em.find( Partie.class, id );
	}

	public void ajouterPartie( Partie partie )
	{
		em.persist( partie );
	}

	public void updatePartie( Partie partie )
	{
		em.merge( partie );
	}
}
