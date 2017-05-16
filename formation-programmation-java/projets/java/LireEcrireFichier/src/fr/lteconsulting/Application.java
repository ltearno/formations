package fr.lteconsulting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application
{
	public static void main( String[] args )
	{
		enregistrer();

		lire();
	}

	static void lire()
	{
		File file = new File( "utilisateurs.data" );
		if( !file.exists() )
			return;

		List<Utilisateur> resultat = new ArrayList<>();
		try
		{
			FileInputStream fis = new FileInputStream( file );
			InputStreamReader isr = new InputStreamReader( fis );
			BufferedReader reader = new BufferedReader( isr );

			while( true )
			{
				String line = reader.readLine();
				if( line == null )
					break;

				String[] parts = line.split( ";" );

				Utilisateur u = new Utilisateur( parts[0], parts[1] );
				resultat.add( u );
			}

			reader.close();
			isr.close();
			fis.close();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		System.out.println( resultat );
	}

	static void enregistrer()
	{
		List<Utilisateur> users = Arrays.asList( new Utilisateur( "Toto", "Arnaud" ), new Utilisateur( "Toto", "ArnaADDADud" ), new Utilisateur( "Tätä", "Aarnaaaaaaud" ), new Utilisateur( "Rrffto", "Adfgdfdfggrnaud" ), new Utilisateur( "Titi", "Adkdjahgdkjh" ) );

		try
		{
			File file = new File( "utilisateurs.data" );

			FileOutputStream fos = new FileOutputStream( file );
			PrintWriter pw = new PrintWriter( fos );

			for( Utilisateur user : users )
			{
				pw.printf( "%s;%s\n", user.getNom(), user.getPrenom() );
			}

			pw.close();
			fos.close();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}
