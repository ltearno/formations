package fr.lteconsulting;

import java.io.File;
import java.util.List;

public class BatailleFermee
{
	public static void main( String[] args )
	{
		faireLesTests();

		int numeroPartie = 1;
		int nbJoueur1Gagne = 0;
		int nbJoueur2Gagne = 0;
		int nbNuls = 0;
		while( true )
		{
			System.out.println( "Partie " + numeroPartie++ );

			Joueur joueur1 = new Joueur();
			Joueur joueur2 = new Joueur();

			Partie partie = new Partie();
			Joueur gagnant = partie.deroulerPartie( joueur1, joueur2 );

			System.out.println( "gagnant: " + gagnant );

			if( gagnant == joueur1 )
				nbJoueur1Gagne++;
			else if( gagnant == joueur2 )
				nbJoueur2Gagne++;
			else
				nbNuls++;

			System.out.println( nbJoueur1Gagne + " vs " + nbJoueur2Gagne + " (" + nbNuls + ")" );
		}
	}

	private static void faireLesTests()
	{
		FabriqueDeck fabriqueDeck = new FabriqueDeck();

		List<Carte> deck = fabriqueDeck.genere52Cartes();
		assert deck.size() == 52;

		System.out.println( deck );
	}
}
