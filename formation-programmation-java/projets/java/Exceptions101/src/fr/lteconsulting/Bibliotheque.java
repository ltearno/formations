package fr.lteconsulting;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Bibliotheque
{
	public void ajouterDisque( String codeBarre ) throws AjoutDisqueImpossibleException
	{
		// vérifier que le code varre n'existe pas déja dans la bibliotheque
		// si c'est pas le cas, jeter une exception DisqueDejaPresentException
		// throw new AjoutDisqueImpossibleException("Le code barrre exitse deja");
		// sinon on ajoute le disques

		try
		{
			PrintWriter pw = new PrintWriter( "K:iuiuyt.txt" );
		}
		catch( FileNotFoundException e )
		{
			throw new AjoutDisqueImpossibleException( "Fichier en erreur", e );
		}

	}
}
