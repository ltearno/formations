package fr.lteconsulting;

public class Jeu
{
	private ICarte[] cartes;

	public Jeu( int nbCartesMax )
	{
		cartes = new ICarte[nbCartesMax];
	}

	public void piocher( ICarte carteAjoutee )
	{
		for( int i = 0; i < cartes.length; i++ )
		{
			if( cartes[i] == null )
			{
				cartes[i] = carteAjoutee;
				return;
			}
		}

		System.out.println( "Je n'ai plus de place dasn mon jeu" );
	}

	public void joue()
	{
		ICarte carteJouee = selectionnerEtSortirCarte();

		System.out.println( "Je joue une carte..." );
		System.out.println( "La carte jouée est :" );
		carteJouee.afficher();
	}

	public void afficher()
	{
		for( ICarte carte : cartes )
		{
			if( carte != null )
				carte.afficher();
		}
	}

	private ICarte selectionnerEtSortirCarte()
	{
		for( int i = 0; i < cartes.length; i++ )
		{
			if( cartes[i] != null )
			{
				ICarte carteSelectionnee = cartes[i];
				cartes[i] = null;

				return carteSelectionnee;
			}
		}

		return null;
	}
}
