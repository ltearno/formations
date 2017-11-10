package fr.lteconsulting.outils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saisie
{
	public static String saisie( String message )
	{
		System.out.println( message );
		System.out.print( "> " );

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		try
		{
			String result = reader.readLine();
			if( result != null && result.trim().isEmpty() )
				return null;

			return result;
		}
		catch( IOException e )
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Demande à l'utilisateur de saisir un nombre entre 0 et max
	 */
	public static int saisieInt( String message, int max )
	{
		while( true )
		{
			int saisie = saisieInt( message );
			if( saisie >= 0 && saisie <= max )
				return saisie;

			System.out.println( "Oula on a dit min 0 et max " + max + " !!!" );
		}
	}

	public static int saisieInt( String message )
	{
		while( true )
		{
			try
			{
				String result = saisie( message );

				return Integer.parseInt( result );
			}
			catch( Exception e )
			{
				System.out.println( "!!! Non, entrez un nombre s'il vous plait !!!" );
			}
		}
	}
}
