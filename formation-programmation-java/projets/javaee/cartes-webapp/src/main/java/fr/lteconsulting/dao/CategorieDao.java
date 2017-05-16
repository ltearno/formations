package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import fr.lteconsulting.model.Categorie;

@Stateless
public class CategorieDao
{
	private int nextId = 1;

	private List<Categorie> categories = new ArrayList<>();

	public List<Categorie> getCategories()
	{
		return categories;
	}

	public void addCategorie( Categorie categorie )
	{
		categorie.setId( nextId++ );

		categories.add( categorie );
	}

	public void saveCategorie( Categorie categorie )
	{
		Categorie dansListe = getCategorie( categorie.getId() );
		int index = categories.indexOf( dansListe );
		categories.set( index, categorie );
	}

	public void delete( int id )
	{
		categories.remove( getCategorie( id ) );
	}

	public Categorie trouverCategorieParNom( String nom )
	{
		for( Categorie c : categories )
			if( c.getNom().equals( nom ) )
				return c;
		return null;
	}

	private Categorie getCategorie( int id )
	{
		for( Categorie c : categories )
			if( c.getId() == id )
				return c;
		
		return null;
	}
}