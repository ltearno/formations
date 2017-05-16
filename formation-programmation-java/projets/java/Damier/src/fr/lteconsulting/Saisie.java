package fr.lteconsulting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.lteconsulting.bidon.CouleurNB;

public class Saisie
{
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

	public static Coordonnee saisieCoordonnee( String message )
	{
		while( true )
		{
			try
			{
				String reponse = saisie( message );

				String[] parts = reponse.split( ";" );

				int abscisse = Integer.parseInt( parts[0] );
				int ordonnee = Integer.parseInt( parts[1] );

				return new Coordonnee( abscisse - 1, ordonnee - 1 );
			}
			catch( Exception e )
			{
				System.out.println( "NON! essaye encore" );
			}
		}
	}

	public static CouleurNB saisieCouleurNB( String message )
	{
		message += " (";
		for( CouleurNB valeurPossible : CouleurNB.values() )
			message += valeurPossible + " ";
		message += " )";

		String saisieUtilisateur = saisie( message );
		return CouleurNB.valueOf( saisieUtilisateur );
	}

	public static boolean estNumerique( String s )
	{
		for( int i = 0; i < s.length(); i++ )
		{
			char c = s.charAt( i );
			if( !Character.isDigit( c ) )
				return false;
		}

		return true;
	}

}
