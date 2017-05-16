package fr.lteconsulting;

import java.io.File;
import java.io.FileInputStream;

public class HexDump
{
	public static void main( String[] args )
	{
		try
		{
			// ouvrir un fichier
			FileInputStream fis = new FileInputStream( new File( "..\\Morpion\\plateau.data" ) );

			// lire son contenu par bloc de 16 octets
			// preparer un buffer
			byte[] buffer = new byte[16];

			int adresse = 0;
			while( adresse < 1024 )
			{
				int nbRead = fis.read( buffer );
				if( nbRead == 0 )
					break;

				// afficher la ligne
				String ligne = String.format( "%08x: ", adresse );
				for( int i = 0; i < nbRead; i++ )
				{
					byte b = buffer[i];
					ligne += String.format( "%02x ", b );

					if( (i + 1) % 4 == 0 )
						ligne += " ";
				}
				for( int i = 0; i < nbRead; i++ )
				{
					byte b = buffer[i];
					if( b >= 32 && b <= 126 )
						ligne += (char) b;
					else
						ligne += ".";
				}

				adresse += 16;

				System.out.println( ligne );

				if( nbRead < 16 )
					break;
			}

			// afficher chaque ligne
			// fermer le fichier
			fis.close();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}
