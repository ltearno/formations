package fr.lteconsulting;

import java.util.List;

public class AfficherNombre extends Commande
{
	@Override
	public void execute( List<String> mots )
	{
		System.out.println( "\nNombre de mots : " + mots.size() );
	}
	
	@Override
	public String toString()
	{
		return "Afficher le nombre de mots";
	}
}
