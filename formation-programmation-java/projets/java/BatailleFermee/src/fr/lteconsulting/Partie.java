package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partie
{
	public Joueur deroulerPartie( Joueur joueur1, Joueur joueur2 )
	{
		FabriqueDeck fabriqueDeck = new FabriqueDeck();

		List<Carte> deck = fabriqueDeck.genere32Cartes();

		Collections.shuffle( deck );

		distribuerCarte( deck, new Joueur[] { joueur1, joueur2 } );

		int tour = 0;
		List<Carte> encours = new ArrayList<>();
		while( tour++ < 5000 )
		{
			// System.out.println( "Joueur1 : " + joueur1.getNbCartes() + " cartes" );
			// System.out.println( "Joueur2 : " + joueur2.getNbCartes() + " cartes" );

			Carte c1 = joueur1.donneCarte();
			Carte c2 = joueur2.donneCarte();

			if( c1 == null )
				return joueur1;
			if( c2 == null )
				return joueur2;

			int comparaison = compareCartes( c1, c2 );

			// System.out.println( c1 + " vs " + c2 + " => " + comparaison );

			encours.add( c1 );
			encours.add( c2 );

			if( comparaison > 0 )
			{
				donneEncoursA( encours, joueur1 );
			}
			else if( comparaison < 0 )
			{
				donneEncoursA( encours, joueur2 );
			}
			else
			{
				encours.add( joueur1.donneCarte() );
				encours.add( joueur2.donneCarte() );
			}
		}

		return null;
	}

	private void donneEncoursA( List<Carte> encours, Joueur destinataire )
	{
		for( Carte carte : encours )
			destinataire.prendCarte( carte );
		encours.clear();
	}

	// TODO : Carte pourrait implémenter Comparable
	private int compareCartes( Carte c1, Carte c2 )
	{
		return Integer.compare( c1.getValeur(), c2.getValeur() );
	}

	private void distribuerCarte( List<Carte> deck, Joueur[] joueurs )
	{
		int current = 0;
		for( Carte carte : deck )
		{
			joueurs[(current++) % joueurs.length].prendCarte( carte );
		}
	}
}
