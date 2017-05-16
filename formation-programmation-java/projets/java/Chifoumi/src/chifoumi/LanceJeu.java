package chifoumi;

public class LanceJeu
{
	public static void main( String[] args )
	{
		if( args.length != 3 )
		{
			System.out.println( "Veuillez indiquer le nom des deux joueurs ainsi que le score à atteindre en paramètre !" );
			System.out.println( "Nous allons utiliser les paramètres par défaut" );

			args = new String[] { "Joueur1", "Joueur2", "5" };
		}

		Jeu jeu = new Jeu( args[0], args[1], Integer.parseInt( args[2] ) );
		jeu.jouer();

		System.exit( 0 );
	}
}
