package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
	List<Commande> choixPossibles = new ArrayList<>();

	public void ajouterChoix( Commande choix )
	{
		choixPossibles.add( choix );
	}

	public Commande presenterMenu()
	{
		System.out.println( "=== MENU" );
		for( int i = 0; i < choixPossibles.size(); i++ )
			System.out.println( (i + 1) + ". "
					+ choixPossibles.get( i ).getTitre() );

		int choix = Saisie.saisieInt( "Votre choix" ) - 1;
		if( choix < 0 || choix >= choixPossibles.size() )
			return null;

		return choixPossibles.get( choix );
	}
}




