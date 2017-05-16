package fr.lteconsulting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopierFichier
{
	public static void main( String[] args )
	{
		File source = new File( "C:\\w\\eclipse-mars\\Stocks.war" );
		File destination = new File( "C:\\Tmp\\Stocks.war" );

		if( destination.exists() )
		{
			System.out.println( "La destination existe déjà, on la supprime..." );
			destination.delete();
		}

		copier( source, destination );
	}

	private static void copier( File source, File destination )
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try
		{
			// On prépare deux streams nous permettant de lire dans la source
			// et d'écrire dans la destination
			fis = new FileInputStream( source );
			fos = new FileOutputStream( destination );

			// on crée une zone mémoire qui va nous permettre de faire transiter les données
			// entre la source et la destination (on appelle cela un buffer)
			byte[] buffer = new byte[512];

			int nbBytesRead = 0;

			// on boucle tant qu'il y a des octets à lire
			while( (nbBytesRead = fis.read( buffer )) > 0 )
			{
				// après lecture, le buffer contient les nbBytesRead lus

				// on écrit ces octets dans le fichier destination
				fos.write( buffer, 0, nbBytesRead );
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

			try
			{
				if( fos != null )
					fos.close();
			}
			catch( IOException e )
			{
				e.printStackTrace();
			}

			System.out.println( "Copie terminée" );
		}
	}
}
