package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApplicationData implements IApplicationData
{
	private List<Carte> cartes;

	@Override
	public List<Carte> getCartes()
	{
		if( cartes == null )
		{
			cartes = new ArrayList<>();
			for( int i = 1; i < 100; i++ )
				cartes.add( new Carte( nomCarte(), couleur() ) );
		}

		return cartes;
	}

	@Override
	public void ajouterCarte( Carte carte )
	{
		if( getCarte( carte.getId() ) != null )
			throw new IllegalArgumentException( "La carte existe déjà !!" );

		cartes.add( carte );
	}

	@Override
	public void removeCarte( String id )
	{
		List<Carte> cartes = getCartes();

		for( int i = 0; i < cartes.size(); i++ )
		{
			Carte carte = cartes.get( i );
			if( carte.getId().equals( id ) )
			{
				cartes.remove( i );
				break;
			}
		}
	}

	@Override
	public Carte getCarte( String id )
	{
		for( Carte carte : getCartes() )
			if( carte.getId().equals( id ) )
				return carte;
		return null;
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
