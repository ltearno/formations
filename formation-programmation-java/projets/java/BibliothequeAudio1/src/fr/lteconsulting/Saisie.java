package fr.lteconsulting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Saisie
{
	public static ICommande saisieMenu( String titreMenu, List<ICommande> commandes )
	{
		System.out.println( "\n## " + titreMenu + " ##\n" );
		for( int i = 0; i < commandes.size(); i++ )
		{
			ICommande commande = commandes.get( i );

			System.out.println( (i + 1) + ". " + commande.getTitre() );
		}

		int choix = Saisie.saisieInt( "Entrez le numéro du choix" );

		return commandes.get( choix - 1 );
	}

	public static String saisie( String message )
	{
		System.out.println( message );
		System.out.print( "> " );

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		try
		{
			return reader.readLine();
		}
		catch( IOException e )
		{
			e.printStackTrace();
			return null;
		}
	}

	public static int saisieInt( String message )
	{
		String result = saisie( message );

		return Integer.parseInt( result );
	}
}
