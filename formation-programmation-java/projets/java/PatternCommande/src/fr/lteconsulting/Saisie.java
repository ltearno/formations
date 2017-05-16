package fr.lteconsulting;

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
