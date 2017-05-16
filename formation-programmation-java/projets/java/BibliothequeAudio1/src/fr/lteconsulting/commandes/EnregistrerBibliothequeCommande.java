package fr.lteconsulting.commandes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Chanson;
import fr.lteconsulting.Disque;

public class EnregistrerBibliothequeCommande extends CommandeBase
{
	public EnregistrerBibliothequeCommande()
	{
		super( "Enregistrer la base de données" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		File file = new File( "bibliotheque.dat" );

		try
		{
			FileOutputStream fos = new FileOutputStream( file );
			PrintWriter pw = new PrintWriter( fos );

			pw.println( "MAGIC_TEXT!!!" );
			pw.println( "VERSION:1" );

			for( Disque disque : contexte.getBibliotheque().getDisques() )
				enregistrerDisque( disque, pw );

			pw.close();
			fos.close();
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}

	private void enregistrerDisque( Disque disque, PrintWriter pw )
	{
		pw.printf( "%s;%s\n", disque.getCodeBarre(), disque.getNom() );
		pw.printf( "%d\n", disque.getChansons().size() );
		for( Chanson chanson : disque.getChansons() )
			enregistrerChanson( chanson, pw );
	}

	private void enregistrerChanson( Chanson chanson, PrintWriter pw )
	{
		pw.printf( "%s;%d\n", chanson.getNom(), chanson.getDuree() );
	}
}
