package fr.lteconsulting.formations;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.lteconsulting.formations.model.Collaborateur;
import fr.lteconsulting.formations.model.DemandeFormation;
import fr.lteconsulting.formations.model.Formation;

public class DatabaseConnectionTest
{
	@Test
	public void testEntityManager()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "formations" );
		assertNotNull( emf );

		EntityManager em = emf.createEntityManager();
		assertNotNull( em );

		em.getTransaction().begin();

		Formation formation = new Formation();
		formation.setIntitule( "Java" );
		formation.setLieu( "Toulouse" );
		formation.setNbJours( new BigDecimal( "47" ) );
		formation.setNomPrestataire( "AELION" );
		formation.setDebutAttendu( new Date() );
		formation.setDebutReel( null );
		em.persist( formation );

		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setNom( "Tournier" );
		collaborateur.setPrenom( "Arnaud" );
		collaborateur.setCodeAgence( "101" );
		em.persist( collaborateur );

		DemandeFormation demande = new DemandeFormation();
		demande.setCollaborateur( collaborateur );
		demande.setFormation( formation );
		em.persist( demande );

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
