package chifoumi;

public class JeuUnTour
{
	private Joueur joueur1;
	private Joueur joueur2;

	public JeuUnTour( String nomJoueur1, String nomJoueur2 )
	{
		joueur1 = new Joueur( nomJoueur1 );
		joueur2 = new Joueur( nomJoueur2 );
	}

	public void jouer()
	{
		tour();
		joueur1.ecrireScore();
		joueur2.ecrireScore();
		conclure();
	}

	@SuppressWarnings( "incomplete-switch" )
	private void tour()
	{
		Choix choixJoueur1 = joueur1.choisir();
		Choix choixJoueur2 = joueur2.choisir();

		Joueur joueurGagnant = null;

		switch( choixJoueur1 )
		{
			case CAILLOU:
				switch( choixJoueur2 )
				{
					case CISEAUX:
						joueurGagnant = joueur2;
						break;
					case PAPIER:
						joueurGagnant = joueur2;
						break;
				}
				break;

			case CISEAUX:
				switch( choixJoueur2 )
				{
					case CAILLOU:
						joueurGagnant = joueur2;
						break;
					case PAPIER:
						joueurGagnant = joueur1;
						break;
				}
				break;

			case PAPIER:
				switch( choixJoueur2 )
				{
					case CAILLOU:
						joueurGagnant = joueur1;
						break;
					case CISEAUX:
						joueurGagnant = joueur2;
						break;
				}
				break;
		}

		if( joueurGagnant != null )
			joueurGagnant.crediter();
	}

	private void conclure()
	{
		int scoreJoueur1 = joueur1.getScore();
		int scoreJoueur2 = joueur2.getScore();

		if( scoreJoueur1 == scoreJoueur2 )
		{
			System.out.println( "Les deux joueurs font égalité" );
		}
		else if( scoreJoueur1 > scoreJoueur2 )
		{
			System.out.println( "Le joueur " + joueur1.getNom() + " a gagné !" );
		}
		else
		{
			System.out.println( "Le joueur " + joueur2.getNom() + " a gagné !" );
		}
	}
}
