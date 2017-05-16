package fr.lteconsulting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu
{
	private List<Commande> commandes;
	private Map<String, Commande> raccourcis;

	public Menu()
	{
		commandes = new ArrayList<>();
		raccourcis = new HashMap<>();
	}

	public void addCommande( Commande commande )
	{
		commandes.add( commande );
	}

	public void addCommande( Commande commande, String raccourci )
	{
		commandes.add( commande );
		raccourcis.put( raccourci, commande );
	}

	public Commande afficher()
	{
		System.out.println( "\n-- MENU" );

		for( int i = 0; i < commandes.size(); i++ )
		{
			Commande commande = commandes.get( i );
			System.out.println( (1 + i) + ". " + commande );
		}

		String saisie = Saisie.saisie( "Quel choix ?" );

		try
		{
			int numero = Integer.parseInt( saisie );
			return commandes.get( numero - 1 );
		}
		catch( NumberFormatException e )
		{
			return raccourcis.get( saisie );
		}
	}
}
