package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lteconsulting.Produit;

public class ProduitDAOHashMap implements ProduitDAO
{
	private Map<Integer, Produit> stock = new HashMap<>();

	@Override
	public List<Produit> getAll()
	{
		List<Produit> result = new ArrayList<>();
		for( Produit produit : stock.values() )
			result.add( produit );
		return result;
	}

	@Override
	public Produit getOne( int reference )
	{
		return stock.get( reference );
	}

	@Override
	public void addProduit( Produit produit )
	{
		stock.put( produit.getReference(), produit );
	}

	@Override
	public void updateProduit( Produit produit )
	{
		stock.put( produit.getReference(), produit );
	}

	@Override
	public void deleteProduit( int reference )
	{
		stock.remove( reference );
	}
}
