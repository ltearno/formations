package fr.lteconsulting;

import java.util.List;

import fr.lteconsulting.dao.ProduitDAO;
import fr.lteconsulting.exception.DAOException;

public class Entrepot
{
	private ProduitDAO produitDao;

	public Entrepot( ProduitDAO produitDAO )
	{
		this.produitDao = produitDAO;
	}

	public Produit rechercheParReference( int reference )
	{
		try
		{
			return produitDao.getOne( reference );
		}
		catch( DAOException e )
		{
			e.printStackTrace();
			return null;
		}
	}

	public void ajouterProduit( Produit produit )
	{
		try
		{
			produitDao.addProduit( produit );
		}
		catch( DAOException e )
		{
			e.printStackTrace();
		}
	}

	public void afficherStock()
	{
		try
		{
			List<Produit> produits = produitDao.getAll();
			for( Produit produit : produits )
				produit.afficher();
		}
		catch( DAOException e )
		{
			e.printStackTrace();
		}
	}
}
