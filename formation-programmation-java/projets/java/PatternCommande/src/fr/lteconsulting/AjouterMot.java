package fr.lteconsulting;

import java.util.List;

public class AjouterMot extends Commande
{
	@Override
	public void execute( List<String> mots )
	{
		System.out.println( "\nAjouter un mot" );
		String mot = Saisie.saisie( "Quel mot voulez-vous ajouter ?" );
		mots.add( mot );
	}

	@Override
	public String toString()
	{
		return "Ajouter un mot";
	}
}
