package fr.lteconsulting;

public class Application
{
	public static void main( String[] args )
	{
		Conway conway = new Conway( 800, 800 );

		// conway.initializeRandomly();

		conway.putFrog( 5, 5 );

		conway.putU( 20, 20 );

		for( int i = 0; i < 5; i++ )
			conway.putFigure( i * 40, 0, new String[] {
					"                        X           ",
					"                      X X           ",
					"            XX      XX            XX",
					"           X   X    XX            XX",
					"XX        X     X   XX              ",
					"XX        X   X XX    X X           ",
					"          X     X       X           ",
					"           X   X                    ",
					"            XX                      "
			} );

		conway.putFigure( 323, 100, new String[] {
				"XXXX              ",
				"X   X         X   ",
				"X           XX    ",
				" X  X  XX     XXX ",
				"      XXX      XXX",
				" X  X  XX     XXX ",
				"X           XX    ",
				"X   X         X   ",
				"XXXX              "
		} );

		BoardDisplay.displayBoard( conway );

		// int nbRounds = 110;
		// for( int round = 1; round <= nbRounds; round++ )
		// {
		// System.out.println( "Round " + round );
		//
		// conway.display();
		// conway.evolve();
		// }
	}
}
