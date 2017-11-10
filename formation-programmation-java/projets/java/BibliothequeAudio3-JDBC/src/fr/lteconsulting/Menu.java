package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.outils.Saisie;

public class Menu
{
	private String titre;

	private List<Commande> commandes = new ArrayList<>();

	public Menu( String titre )
	{
		this.titre = titre;
	}

	public void ajouterCommande( Commande commande )
	{
		commandes.add( commande );
	}

	public Commande saisirCommmande()
	{
		int lineWidth = titre.length();

		String[] titresCommandes = new String[commandes.size()];
		for( int i = 0; i < commandes.size(); i++ )
		{
			titresCommandes[i] = (i + 1) + ". " + commandes.get( i ).getNom();

			// on se souvient de la taille max
			if( lineWidth < titresCommandes[i].length() )
				lineWidth = titresCommandes[i].length();
		}

		// pour avoir des espaces
		lineWidth += 4;

		System.out.println();

		printOpeningLine( lineWidth );
		printRightJustified( titre, lineWidth );
		printLineBreak( lineWidth );

		for( int i = 0; i < commandes.size(); i++ )
		{
			printLeftJustified( titresCommandes[i], lineWidth );
		}

		printLineBreak( lineWidth );

		int choix = Saisie.saisieInt( "Faites votre choix (entre 1 et " + commandes.size() + ")" );

		Commande commandeChoisie = commandes.get( choix - 1 );

		printClosingLine( lineWidth );
		System.out.println();

		return commandeChoisie;
	}

	public void printOpeningLine( int lineWidth )
	{
		System.out.print( "/" );
		for( int i = 0; i < lineWidth - 2; i++ )
			System.out.print( "-" );
		System.out.println( "\\" );
	}

	public void printClosingLine( int lineWidth )
	{
		System.out.print( "\\" );
		for( int i = 0; i < lineWidth - 2; i++ )
			System.out.print( "-" );
		System.out.println( "/" );
	}

	void printLeftJustified( String text, int lineWidth )
	{
		System.out.print( "| " );
		System.out.print( text );
		int paddingRight = lineWidth - text.length() - 3;
		for( int i = 0; i < paddingRight; i++ )
			System.out.print( " " );
		System.out.println( "|" );
	}

	void printRightJustified( String text, int lineWidth )
	{
		System.out.print( "|" );
		int offsetLeft = lineWidth - text.length() - 3;
		for( int i = 0; i < offsetLeft; i++ )
			System.out.print( " " );
		System.out.print( text );
		System.out.println( " |" );
	}

	void printLineBreak( int lineWidth )
	{
		System.out.print( "|" );
		for( int i = 0; i < lineWidth - 2; i++ )
			System.out.print( "-" );
		System.out.println( "|" );
	}
}
