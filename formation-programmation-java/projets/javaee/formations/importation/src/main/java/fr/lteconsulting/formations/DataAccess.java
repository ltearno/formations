package fr.lteconsulting.formations;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.lteconsulting.formations.model.Collaborateur;
import fr.lteconsulting.formations.model.DemandeFormation;
import fr.lteconsulting.formations.model.Formation;

public class DataAccess
{
	private final TransactionManager tx;

	public DataAccess( TransactionManager tx )
	{
		this.tx = tx;
	}

	public List<Formation> getFormations()
	{
		return tx.withinTransaction( em -> em.createQuery( "from Formation f", Formation.class ).getResultList() );
	}

	public Formation maybeAddFormation( Formation formation )
	{
		return tx.withinTransaction( em -> {
			try
			{
				Query query = em.createQuery( "from Formation f where"
						+ " ((:intitule is null and f.intitule is null) or (:intitule is not null and f.intitule=:intitule))"
						+ " and ((:lieu is null and f.lieu is null) or (:lieu is not null and f.lieu=:lieu))"
						+ " and ((:debutAttendu is null and f.debutAttendu is null) or (:debutAttendu is not null and f.debutAttendu=:debutAttendu))"
						+ " and ((:debutReel is null and f.debutReel is null) or (:debutReel is not null and f.debutReel=:debutReel))"
						+ " and ((:nbJours is null and f.nbJours is null) or (nbJours is not null and f.nbJours=:nbJours))"
						+ " and ((:nomPrestataire is null and f.nomPrestataire is null) or (:nomPrestataire is not null and f.nomPrestataire=:nomPrestataire))" )
						.setParameter( "intitule", formation.getIntitule() )
						.setParameter( "lieu", formation.getLieu() )
						.setParameter( "debutAttendu", formation.getDebutAttendu() )
						.setParameter( "debutReel", formation.getDebutReel() )
						.setParameter( "nbJours", formation.getNbJours() )
						.setParameter( "nomPrestataire", formation.getNomPrestataire() );

				return (Formation) query.getSingleResult();
			}
			catch( NoResultException e )
			{
				em.persist( formation );

				return formation;
			}
		} );
	}

	public Collaborateur maybeAddCollaborateur( Collaborateur collaborateur )
	{
		return tx.withinTransaction( em -> {
			try
			{
				Query query = em.createQuery( "from Collaborateur c where"
						+ " ((:nom is null and c.nom is null) or (:nom is not null and c.nom=:nom))"
						+ " and ((:prenom is null and c.prenom is null) or (:prenom is not null and c.prenom=:prenom))"
						+ " and ((:codeAgence is null and c.codeAgence is null) or (:codeAgence is not null and c.codeAgence=:codeAgence))" )
						.setParameter( "nom", collaborateur.getNom() )
						.setParameter( "prenom", collaborateur.getPrenom() )
						.setParameter( "codeAgence", collaborateur.getCodeAgence() );

				return (Collaborateur) query.getSingleResult();
			}
			catch( NoResultException e )
			{
				em.persist( collaborateur );
				return collaborateur;
			}
		} );
	}

	public DemandeFormation maybeAddDemandeFormation( DemandeFormation demandeFormation )
	{
		return tx.withinTransaction( em -> {
			try
			{
				Query query = em.createQuery( "from DemandeFormation d where d.collaborateur=:collaborateur and d.formation=:formation" )
						.setParameter( "formation", demandeFormation.getFormation() )
						.setParameter( "collaborateur", demandeFormation.getCollaborateur() );

				return (DemandeFormation) query.getSingleResult();
			}
			catch( NoResultException e )
			{
				em.persist( demandeFormation );
				return demandeFormation;
			}
		} );
	}
}
