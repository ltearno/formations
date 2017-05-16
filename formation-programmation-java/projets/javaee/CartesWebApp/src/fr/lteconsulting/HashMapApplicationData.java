package fr.lteconsulting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HashMapApplicationData implements IApplicationData
{
	private Map<String, Carte> cartes;

	@Override
	public List<Carte> getCartes()
	{
		if( cartes == null )
		{
			cartes = new HashMap<>();
			for( int i = 1; i < 100; i++ )
			{
				Carte carte = new Carte( nomCarte(), couleur() );
				cartes.put( carte.getId(), carte );
			}
		}

		return new ArrayList<>( cartes.values() );
	}

	@Override
	public void ajouterCarte( Carte carte )
	{
		if( getCarte( carte.getId() ) != null )
			throw new IllegalArgumentException( "La carte existe déjà !!" );

		cartes.put( carte.getId(), carte );
	}

	@Override
	public void removeCarte( String id )
	{
		cartes.remove( id );
	}

	@Override
	public Carte getCarte( String id )
	{
		return cartes.get( id );
	}

	private String syllabe()
	{
		String[] mots = { "jon", "snow", "meli", "sa", "roi", "da", "me", "pick", "a", "chou", "fou", "bat", "man", "woman", "tra", "tri", "bou", "belz", "crat" };

		return mots[new Random().nextInt( mots.length )];
	}

	private String nomCarte()
	{
		int nbSyllabes = 1 + new Random().nextInt( 3 );

		StringBuilder sb = new StringBuilder();
		while( nbSyllabes-- > 0 )
			sb.append( syllabe() );

		String res = sb.toString();

		return res.substring( 0, 1 ).toUpperCase() + res.substring( 1 );
	}

	private String couleur()
	{
		String res = "#";
		for( int i = 0; i < 6; i++ )
			res += "" + new Random().nextInt( 10 );
		return res;
	}
}
