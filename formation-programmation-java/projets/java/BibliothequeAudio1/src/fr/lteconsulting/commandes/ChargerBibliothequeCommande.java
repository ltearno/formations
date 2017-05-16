package fr.lteconsulting.commandes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Chanson;
import fr.lteconsulting.Disque;
import fr.lteconsulting.DisqueDejaPresentException;

public class ChargerBibliothequeCommande extends CommandeBase
{
	public ChargerBibliothequeCommande()
	{
		super( "Charger la base de données" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		File file = new File( "bibliotheque.dat" );

		try( FileInputStream fis = new FileInputStream( file ); InputStreamReader isr = new InputStreamReader( fis, "UTF8" ); BufferedReader reader = new BufferedReader( isr ); )
		{
			String line = reader.readLine();
			if( line == null || !line.equals( "MAGIC_TEXT!!!" ) )
				throw new RuntimeException( "Erreur de lecture du Magic, le fichier est surement corrompu" );

			line = reader.readLine();
			if( line == null || !line.equals( "VERSION:1" ) )
				throw new RuntimeException( "Mauvaise version du fichier, format illisible" );

			while( true )
			{
				Disque disque = lireDisque( reader );

				if( disque != null )
				{
					try
					{
						contexte.getBibliotheque().ajouterDisque( disque );
					}
					catch( DisqueDejaPresentException e )
					{
						System.out.println( "Disque déjà présent : " + disque );
					}
				}
				else
				{
					break;
				}
			}
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}

	private Disque lireDisque( BufferedReader reader ) throws IOException
	{
		String line = reader.readLine();
		if( line == null )
			return null;

		String[] parts = line.split( ";" );
		Disque disque = new Disque( parts[1], parts[0] );

		int nbChansons = Integer.parseInt( reader.readLine() );
		while( nbChansons-- > 0 )
		{
			Chanson chanson = lireChanson( reader );
			disque.addChanson( chanson );
		}

		return disque;
	}

	private Chanson lireChanson( BufferedReader reader ) throws IOException
	{
		String line = reader.readLine();
		String[] parts = line.split( ";" );

		Chanson chanson = new Chanson( parts[0], Integer.parseInt( parts[1] ) );

		return chanson;
	}
}
