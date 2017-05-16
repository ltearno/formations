package fr.lteconsulting;

public class Jeu
{
	private Carte[] cartes;

	public Jeu( int nbCartesMax )
	{
		cartes = new Carte[nbCartesMax];
	}

	/**
	 * ajouter une carte au jeu
	 */
	public void piocher( Carte carte )
	{
		for( int i = 0; i < cartes.length; i++ )
		{
			if( cartes[i] == null )
			{
				cartes[i] = carte;
				return;
			}
		}

		System.out.println( "Le jeu est complet, impossible d'ajouter la carte " + carte + " !" );
	}

	public void joue()
	{
		System.out.println( "Je joue une carte..." );

		for( int i = 0; i < cartes.length; i++ )
		{
			if( cartes[i] != null )
			{
				Carte carte = cartes[i];
				cartes[i] = null;
				System.out.println( "La carte jouée est : " );
				carte.afficher();
				return;
			}
		}

		System.out.println( "Je n'ai plus de carte à jouer !!!" );
	}

	public void afficher()
	{
		for( Carte carte : cartes )
		{
			if( carte != null )
				carte.afficher();
		}
	}
}
