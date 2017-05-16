package fr.lteconsulting.formations;

import java.util.ArrayList;
import java.util.List;

public class Appli
{
	public static void main( String[] args )
	{
		List<Personne> liste = new ArrayList<>();

		int nb = Saisie.saisieInt( "nb personnes ?" );
		while( nb-- > 0 )
		{
			Personne p = saisirPersonne();
			liste.add( p );
		}

		for( Personne p : liste )
		{
			System.out.println( p );
		}
	}

	private static Personne saisirPersonne()
	{
		int reponse = Saisie.saisieInt( "Personne (0) ou Employe (1) ?", 1 );

		if( reponse == 0 )
		{
			String nom = Saisie.saisie( "nom" );
			String prenom = Saisie.saisie( "prénom" );
			int code = Saisie.saisieInt( "code postal" );

			return new Personne( nom, prenom, code );
		}
		else
		{
			String nom = Saisie.saisie( "nom" );
			String prenom = Saisie.saisie( "prénom" );
			int code = Saisie.saisieInt( "code postal" );
			String entreprise = Saisie.saisie( "entreprise" );

			return new Employe( nom, prenom, code, entreprise );
		}
	}
}
