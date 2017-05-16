package fr.lteconsulting.formations.server.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.lteconsulting.formations.model.Collaborateur;

@Stateless
public class CollaborateursDao
{
	@PersistenceContext( name = "formations" )
	EntityManager em;

	private BaseDao baseDao = new BaseDao();

	public List<Collaborateur> getAll()
	{
		return baseDao.getAll( em, Collaborateur.class );
	}

	public Collaborateur getById( int id )
	{
		return baseDao.getById( em, Collaborateur.class, id );
	}

	public Collaborateur createOrUpdate( Collaborateur record )
	{
		return baseDao.createOrUpdate( em, Collaborateur.class, record );
	}

	public void delete( int id )
	{
		baseDao.delete( em, Collaborateur.class, id );
	}
}
