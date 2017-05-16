package fr.lteconsulting;

import java.io.File;

public class Application
{
	public static void main( String[] args )
	{
		File file = new File( "fichier.txt" );
		
		file.exists();
		
		file.isDirectory();
		file.isFile();
		file.delete();
		file.canWrite();
		file.length();
		
		file.getAbsolutePath();
		
		
		File directory = new File( "images\\jardin" );
		
		if( ! directory.exists() )
			directory.mkdirs();
	}
}
