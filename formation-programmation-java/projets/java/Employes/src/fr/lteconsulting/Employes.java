package fr.lteconsulting;

import java.util.Random;

public class Employes
{
	public static void main( String[] args )
	{
		Employe[] employes = new Employe[20];

		for( int i = 0; i < employes.length; i++ )
			employes[i] = creerEmploye( i );

		payerEmployes( employes );
	}

	private static void payerEmployes( Employe[] employes )
	{
		Random rnd = new Random();

		for( Employe employe : employes )
		{
			int nbHeuresTravaillees = 20 + rnd.nextInt( 35 );
			double salaire = employe.getSalaire( nbHeuresTravaillees );

			System.out.println( "Salarié " + employe.getNom() + " (" + employe.getCategorie() + ") reçoit " + salaire + " pour " + nbHeuresTravaillees + " heures de travail" );
		}
	}

	private static Employe creerEmploye( int index )
	{
		if( Math.random() >= 0.5 )
			return new Employe( "Ouvrier " + index );
		else
			return new EmployeTempsPartiel( "Interim " + index );
	}
}
