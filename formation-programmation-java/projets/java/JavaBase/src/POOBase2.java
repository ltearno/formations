
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

		t = trier( t );

		for( int i = 0; i < t.length; i++ )
			t[i].affichePersonne();
	}

	static Personne[] trier( Personne[] tableau )
	{
		if( tableau.length <= 1 )
			return tableau;

		// couper tableau en deux
		int indexMoitie = tableau.length / 2;

		Personne[] moitieUn = extraire( tableau, 0, indexMoitie );
		Personne[] moitieDeux = extraire( tableau, indexMoitie, tableau.length );

		// trier chaque moitie
		moitieUn = trier( moitieUn );
		moitieDeux = trier( moitieDeux );

		// raseembler les deux moitié
		return rassembler( moitieUn, moitieDeux );
	}

	static Personne[] rassembler( Personne[] moitieUn, Personne[] moitieDeux )
	{
		int i1 = 0;
		int i2 = 0;

		Personne[] resultat = new Personne[moitieUn.length + moitieDeux.length];

		for( int iR = 0; iR < resultat.length; iR++ )
		{
			if( i2 == moitieDeux.length
					|| (i1 < moitieUn.length
							&& moitieUn[i1].getCodePostal() < moitieDeux[i2].getCodePostal()) )
			{
				resultat[iR] = moitieUn[i1++];
			}
			else
			{
				resultat[iR] = moitieDeux[i2++];
			}
		}

		return resultat;
	}

	static Personne[] extraire( Personne[] tableau, int debut, int fin )
	{
		int taille = fin - debut;
		Personne[] resultat = new Personne[taille];

		for( int i = 0; i < taille; i++ )
			resultat[i] = tableau[i + debut];

		return resultat;
	}
}
