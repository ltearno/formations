package fr.lteconsulting;

public class Polymorphisme
{
	public static void main( String[] args )
	{
		Oiseau[] oiseaux = new Oiseau[15];
		for( int i = 0; i < oiseaux.length; i++ )
			oiseaux[i] = creerOiseau();

		for( int i = 0; i < oiseaux.length; i++ )
			oiseaux[i].decrire();
	}

	private static Oiseau creerOiseau()
	{
		double r = Math.random();
		if( r >= 0.6666 )
			return new Pie();
		else if( r >= 0.3333 )
			return new Oiseau();
		else
			return new Moineau();
	}
}
