package fr.lteconsulting.formation.generiques;

public class POOBase2
{
	public static void main( String[] args )
	{
		// L'objectif :
		// Créer un tableau 't' de 5 personnes
		// Trier ce tableau par codePostal

		// déclaration : TYPE_VARIABLE NOM_VARIABLE
		// TYPE_VARIABLE : tableau de Personne: Personne[]
		// Personne[] t = new Personne[5];
		// t[0] = new Personne( "titi", "titi", 44000 );
		// t[1] = new Personne( "areazarez", "titi", 44022 );
		// t[2] = new Personne( "mnlknhmlnk", "titi", 41100 );
		// t[3] = new Personne( "fsfzzz", "titi", 44007 );
		// t[4] = new Personne( "VFEZFE", "titi", 14000 );

		// en utilisant la syntaxe suivante
		// int[] ti = new int[] { 12, 14, 6, 2, 9, 123 };

		Personne[] t = new Personne[] {
				new Personne( "titi", "titi", 44100 ),
				new Personne( "areazarez", "titi", 44022 ),
				new Personne( "mnlknhmlnk", "titi", 41100 ),
				new Personne( "fsfzzz", "titi", 44007 ),
				new Personne( "VFEZFE", "titi", 14000 )
		};

		Sorter<Personne> sorter = new Sorter<Personne>( new ComparateurPersonneParCodePostal() );

		t = sorter.trier( t );

		for( int i = 0; i < t.length; i++ )
			t[i].affichePersonne();
	}
}
