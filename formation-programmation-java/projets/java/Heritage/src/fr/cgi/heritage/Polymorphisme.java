package fr.cgi.heritage;

public class Polymorphisme
{
	public static void main( String[] args )
	{
		// un Kiwi est un Oiseau
		Oiseau oiseau;
		oiseau = new Kiwi();
		oiseau.presenteToi();
		oiseau.chante();

		testOiseau( oiseau );

		// un Paon est un Oiseau
		Oiseau paon = new Paon( 4 );
		paon.presenteToi();
		paon.chante();
		// paon.faitLaRoue();

		testOiseau( paon );

		faitFaireLaRoue( paon );
		// faitFaireLaRoue( oiseau );

		faitFaireLaRoue( new Paon( 33 ) );
	}

	static void faitFaireLaRoue( Oiseau oiseau )
	{
		Paon paon = (Paon) oiseau;
		paon.faitLaRoue();
	}

	static void testOiseau( Oiseau oiseau )
	{
		// l'opérateur instanceof permet de savoir si un objet du type demandé
		if( oiseau instanceof Paon )
		{
			System.out.println( "C'est un Paon !!!" );

			Paon paon = (Paon) oiseau;
			paon.faitLaRoue();
		}
		else
		{
			System.out.println( "Ce n'est pas un paon" );
		}
	}
}
