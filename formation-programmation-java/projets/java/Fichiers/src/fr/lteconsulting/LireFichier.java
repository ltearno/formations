package fr.lteconsulting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LireFichier
{
	public static void main( String[] args )
	{
		File fichier = new File( "C:\\Tmp\\QCM1.png" );

		if( !fichier.exists() )
		{
			System.out.println( "Le fichier à lire n'existe pas !!!" );
		}
		else
		{
			lire( fichier );
		}
	}

	private static void lire( File fichier )
	{
		FileInputStream fis = null;

		System.out.printf( "Lecture du fichier '%s' de %d octets\n", fichier.getAbsolutePath(), fichier.length() );

		try
		{
			// On prépare un stream nous permettant de lire les octets dans la source
			fis = new FileInputStream( fichier );

			// on crée une zone mémoire qui va nous permettre de faire transiter les données
			// de la source vers notre programme
			byte[] buffer = new byte[16];

			int nbBytesRead = 0;
			int adresseLecture = 0;

			// on boucle tant qu'il y a des octets à lire
			while( (nbBytesRead = fis.read( buffer )) > 0 )
			{
				System.out.printf( "%08X ", adresseLecture );

				// après lecture, le buffer contient les nbBytesRead lus
				for( int i = 0; i < nbBytesRead; i++ )
					System.out.printf( "%02X ", buffer[i] );

				System.out.println();

				adresseLecture += nbBytesRead;
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( fis != null )
					fis.close();
			}
			catch( IOException e )
			{
				e.printStackTrace();
			}

			System.out.println( "Lecture terminée" );
		}
	}
}
