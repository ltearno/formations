package fr.lteconsulting;

import fr.lteconsulting.bidon.CouleurNB;
import fr.lteconsulting.bidon.Dame;
import fr.lteconsulting.bidon.Galet;
import fr.lteconsulting.bidon.JeuBidon;

public class TestPlateau
{
	public static void main( String[] args )
	{
		// testJeuBidon();
		// testSaisie();
		// testDames();
		// testDeBase();
	}

	private static void testJeuBidon()
	{
		JeuBidon jeu = new JeuBidon();
		jeu.jouer();
	}

	private static void testSaisie()
	{
		Plateau<Piece> plateau = new Plateau<>( 15, 15 );

		int nb = 10;

		while( nb-- > 0 )
		{
			String couleur = Saisie.saisie( "couleur ? (blanc/noir)" );
			int x = Saisie.saisieInt( "saisis l'abscisse" );
			int y = Saisie.saisieInt( "saisis l'ordonnée" );

			Piece piece = null;

			if( "noir".equals( couleur ) )
				piece = new Dame( CouleurNB.Noir );
			else
				piece = new Dame( CouleurNB.Blanc );

			plateau.placer( piece, new Coordonnee( x, y ) );

			plateau.afficher();
		}
	}

	private static void testDames()
	{
		int size = 20;
		Plateau<Dame> plateau = new Plateau<>( size, size );

		for( int i = 0; i < size; i++ )
		{
			plateau.placer( new Dame( CouleurNB.Noir ), new Coordonnee( i, (1 + i) % 2 ) );
			plateau.placer( new Dame( CouleurNB.Noir ), new Coordonnee( i, 2 + (1 + i) % 2 ) );

			plateau.placer( new Dame( CouleurNB.Blanc ), new Coordonnee( i, size - 4 + (1 + i) % 2 ) );
			plateau.placer( new Dame( CouleurNB.Blanc ), new Coordonnee( i, size - 2 + (1 + i) % 2 ) );
		}

		plateau.afficher();
	}

	private static void testDeBase()
	{
		Plateau<Galet> plateau = new Plateau<>( 10, 10 );

		plateau.afficher();

		plateau.placer( new Galet(), new Coordonnee( 1, 3 ) );

		plateau.afficher();
	}
}
