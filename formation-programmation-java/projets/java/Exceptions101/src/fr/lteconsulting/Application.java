package fr.lteconsulting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Application
{
	public static void main( String[] args )
	{
		// Premier test
		/*System.out.println( "TEST 1" );
		try
		{
			for( int x = -10; x <= 10; x++ )
			{
				int f = 1 / x;
				System.out.println( "1/" + x + " = " + f );
			}
		}
		catch( Exception e )
		{
			System.out.println( "Une exception s'est produite !" );
		}

		// Deuxieme test
		System.out.println( "\n\nTEST 2" );
		for( int x = -10; x <= 10; x++ )
		{
			try
			{
				int f = 1 / x;
				System.out.println( "1/" + x + " = " + f );
			}
			catch( Exception e )
			{
				System.out.println( "Une exception s'est produite !" );
			}
		}

		System.out.println( "\nTEST 3 - Ecriture fichier" );
		try
		{
			PrintWriter writer = new PrintWriter( "K:\\toto.txt" );
			writer.println( "COUCOU" );
			writer.close();
		}
		catch( FileNotFoundException e )
		{
			System.out.println( "Erreur, fichier introuvable !! " + e.getMessage() );
			e.printStackTrace();
		}

		System.out.println( "\nTEST 4 - Ecriture fichier" );
		try
		{
			lireFichier();
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}

		try
		{
			int a = 1 / 0;
			List<String> list = null;
			int s = list.size();
		}
		catch( NullPointerException e )
		{
			System.out.println( "NPE" );
		}
		catch( ArithmeticException e )
		{
			System.out.println( "ARITH" );
		}

		testFinally();
		System.out.println( "après testFinally()" );*/

		Bibliotheque bib = new Bibliotheque();
		try
		{
			bib.ajouterDisque( "5436" );
		}
		catch( AjoutDisqueImpossibleException e )
		{
			System.out.println("kjhkljhlkjh");
			e.printStackTrace();
		}
	}

	private static void lireFichier() throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter( "K:\\toto.txt" );
		writer.println( "COUCOU" );
		writer.close();
	}

	private static int testFinally()
	{
		// OUVERTURE FICHIER OU AUTRES RESOURCES
		try
		{
			return 1 / 0;
		}
		catch( Exception e )
		{
			return -1;
		}
		finally
		{
			System.out.println( "Avant le return, je ferme mes resources" );
		}
	}

}
