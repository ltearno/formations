package chifoumi;

public class LanceJeuUnTour
{
	public static void main( String[] args )
	{
		if( args.length != 2 )
		{
			System.out.println( "Veuillez indiquer le nom des deux joueurs en paramètre, mais pas plus !" );
			return;
		}

		JeuUnTour jeuUnTour = new JeuUnTour( args[0], args[1] );
		jeuUnTour.jouer();
	}
}
