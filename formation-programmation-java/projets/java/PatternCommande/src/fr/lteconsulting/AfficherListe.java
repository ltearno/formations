package fr.lteconsulting;

import java.util.List;

public class AfficherListe extends Commande
{
	@Override
	public void execute( List<String> mots )
	{
		System.out.println( "\nListe des mots" );
		for( String s : mots )
			System.out.println( s );
	}
	
	@Override
	public String toString()
	{
		return "Afficher la liste des mots";
	}
}
