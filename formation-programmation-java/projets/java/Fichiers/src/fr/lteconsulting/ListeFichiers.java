package fr.lteconsulting;

import java.io.File;

public class ListeFichiers
{
	public static void main( String[] args )
	{
		System.out.println( "Affichage des lecteurs du PC : " );
		for( File rootFile : File.listRoots() )
			afficherFichiers( rootFile );
		
		System.out.println( "\n\nListage du répertoire c:\\download" );
		afficherFichiers( new File( "c:\\download" ) );
	}

	private static void afficherFichiers( File repertoire )
	{
		System.out.println( repertoire.getAbsolutePath() );

		// On parcourt la liste des fichiers et répertoires
		for( File file : repertoire.listFiles() )
		{
			if( file.isDirectory() )
			{
				System.out.printf( "\t<DIR>\t            \t%s\n", file.getName() );
			}
			else
			{
				System.out.printf( "\t<FILE>\t%12d\t%s\n", file.length(), file.getName() );
			}
		}
	}
}
