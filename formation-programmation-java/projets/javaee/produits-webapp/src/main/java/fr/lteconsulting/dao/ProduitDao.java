package fr.lteconsulting.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.lteconsulting.entity.Produit;

@Stateless
public class ProduitDao
{
	@PersistenceContext( unitName = "GestionStock" )
	private EntityManager em;

	public void removeProduit( int id )
	{
		Produit p = em.find( Produit.class, id );
		em.remove( p );
	}

	public List<Produit> getProduits()
	{
		TypedQuery<Produit> query = em.createQuery( "from Produit", Produit.class );

		List<Produit> result = query.getResultList();

		return result;
	}

	public Produit creerProduit()
	{
		Produit p = new Produit();

		p.setNom( "Toto" );
		p.setPoids( 0.5 );

		// stocker dans la base de données
		em.persist( p );

		return p;
	}
}
