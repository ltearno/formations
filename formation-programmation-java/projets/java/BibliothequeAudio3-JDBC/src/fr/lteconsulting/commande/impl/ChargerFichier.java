package fr.lteconsulting.commande.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class ChargerFichier implements Commande
{
	@Override
	public String getNom()
	{
		return "Chargement de la bibliotheque à partir du fichier";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		try
		{
			System.out.println( "Chargement du fichier en cours..." );

			InputStream inputStream;
			if( "oui".equals( Saisie.saisie( "Utiliser la version zip ? (oui/non)" ) ) )
				inputStream = zipStream( contexte.getDataFilePath() );
			else
				inputStream = flatStream( contexte.getDataFilePath() );

			InputStreamReader inputStreamReader = new InputStreamReader( inputStream, "UTF8" );
			BufferedReader reader = new BufferedReader( inputStreamReader );

			String shouldBeMagicSignature = reader.readLine();
			if( !SauvegardeFichier.MAGIC_SIGNATURE.equals( shouldBeMagicSignature ) )
			{
				System.out.println( "Le fichier est corrompu !" );
				return;
			}

			try
			{
				int nombreDisquesCharges = lireBibliothequeDepuisFichier( contexte.getBibliotheque(), reader );
				System.out.println( "OK, " + nombreDisquesCharges + " disques ont été chargés depuis le fichier " + contexte.getDataFilePath() );
			}
			catch( Exception e )
			{
				System.out.println( "Erreur pendant la lecture du fichier !" );
			}

			reader.close();
		}
		catch( FileNotFoundException e )
		{
			System.out.println( "Le fichier n'existe pas !" );
		}
		catch( UnsupportedEncodingException e )
		{
			System.out.println( "Problème d'encodage, désolé !" );
		}
		catch( IOException e )
		{
			System.out.println( "Erreur d'entrée sortie, le disque dur fonctionne-t-il toujours ?" );
		}
	}

	private int lireBibliothequeDepuisFichier( Bibliotheque bibliotheque, BufferedReader reader ) throws IOException
	{
		int nombreDisques = Integer.parseInt( reader.readLine() );

		for( int i = 0; i < nombreDisques; i++ )
		{
			Disque disque = lireDisqueDepuisFichier( reader );
			if( disque != null )
				bibliotheque.ajouterDisque( disque );
		}

		return nombreDisques;
	}

	private Disque lireDisqueDepuisFichier( BufferedReader reader ) throws IOException
	{
		String nom = reader.readLine();
		String codeBarre = reader.readLine();
		int nombreChansons = Integer.parseInt( reader.readLine() );

		Disque disque = new Disque();
		disque.setNom( nom );
		disque.setCodeBarre( codeBarre );

		while( nombreChansons-- > 0 )
		{
			Chanson chanson = lireChansonDepuisFichier( reader );
			if( chanson != null )
				disque.addChanson( chanson );
		}

		return disque;
	}

	private Chanson lireChansonDepuisFichier( BufferedReader reader ) throws IOException
	{
		String nom = reader.readLine();
		int duree = Integer.parseInt( reader.readLine() );

		return new Chanson( nom, duree );
	}

	private InputStream zipStream( String nomFichier ) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream( nomFichier + ".zip" );
		ZipInputStream zis = new ZipInputStream( fileInputStream, Charset.forName( "UTF8" ) );

		ZipEntry ze = zis.getNextEntry();
		if( ze == null )
			return null;

		if( !nomFichier.equals( ze.getName() ) )
			return null;

		return zis;
	}

	private InputStream flatStream( String nomFichier ) throws FileNotFoundException
	{
		File file = new File( nomFichier );
		return new FileInputStream( file );
	}
}
