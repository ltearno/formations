package fr.lteconsulting.formations.server.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.lteconsulting.formations.model.DemandeFormation;

@Stateless
public class DemandeFormationsDao
{
	@PersistenceContext( name = "formations" )
	EntityManager em;

	private BaseDao baseDao = new BaseDao();

	public List<DemandeFormation> getAll()
	{
		return baseDao.getAll( em, DemandeFormation.class );
	}

	public List<DemandeFormation> findByCollaborateur( int id )
	{
		return em.createQuery( " from DemandeFormation d where d.collaborateur.id=:id", DemandeFormation.class )
				.setParameter( "id", id )
				.getResultList();
	}

	public DemandeFormation getById( int id )
	{
		return baseDao.getById( em, DemandeFormation.class, id );
	}

	public DemandeFormation createOrUpdate( DemandeFormation record )
	{
		return baseDao.createOrUpdate( em, DemandeFormation.class, record );
	}

	public void delete( int id )
	{
		baseDao.delete( em, DemandeFormation.class, id );
	}
}
