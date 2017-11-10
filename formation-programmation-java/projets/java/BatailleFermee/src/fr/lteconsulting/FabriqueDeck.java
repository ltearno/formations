package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class FabriqueDeck
{
	public List<Carte> genere32Cartes()
	{
		return genereCartes( 7 );
	}

	public List<Carte> genere52Cartes()
	{
		return genereCartes( 2 );
	}

	private List<Carte> genereCartes( int startingPosition )
	{
		List<Carte> deck = new ArrayList<>();

		for( Couleur couleur : Couleur.values() )
			for( int valeur = startingPosition; valeur <= 14; valeur++ )
				deck.add( new Carte( couleur, valeur ) );

		return deck;
	}
}
