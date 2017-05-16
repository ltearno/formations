package fr.lteconsulting;

public class Morpion
{
	private Plateau plateau;

	private Joueur[] joueurs = new Joueur[2];

	private int tour = 0;

	public Morpion()
	{
		// TODO : si un fichier de sauvegarde existe, demander à l'utilisateur s'il veut le charger
		plateau = Plateau.chargerPlateau();
		if( plateau == null )
			plateau = new Plateau( 3, 3 );

		joueurs[0] = new Joueur( "Joueur 1", 'O' );
		joueurs[1] = new Joueur( "Joueur 2", 'X' );
	}

	public void jeu()
	{
		// TODO placer la variable tour à la valeur correcte

		while( true )
		{
			plateau.afficher();

			// demander au joueur courant où il veut placer sa piece
			Joueur joueur = joueurs[tour];

			// TODO proposer de quitter sans enregistrer
			String saisie = Saisie.saisie( joueur.getName() + ", coordonnée de la piece (x,y) - ! pour enregistrer et quitter" );
			if( "!".equals( saisie ) )
			{
				Plateau.enregistrerPlateau( plateau );

				System.out.println( "Partie enregistrée, au revoir !" );

				break;
			}

			// TODO gérer les erreurs utilisateur
			// TODO gérer le cas ou une piece est déjà présente

			// saisie est de la forme X,Y
			String[] coordonnees = saisie.split( "," ); // "3,56" => {"3", "56"}

			int x = Integer.parseInt( coordonnees[0] ) - 1;
			int y = Integer.parseInt( coordonnees[1] ) - 1;

			// créer la piece
			Piece piece = new Piece( joueur.getDisplayChar() );

			// placer la piece
			plateau.placerPiece( piece, x, y );

			if( isCoupGagnant( joueur, x, y ) )
			{
				System.out.println( "Bravo " + joueur.getName() + " ! Vous avez gagné, bravo encore." );
				plateau.afficher();
				break;
			}
			else if( !possedeCaseVide() )
			{
				System.out.println( "Match nul !" );
				plateau.afficher();
				break;
			}

			System.out.println( "Très bien joué " + joueur.getName() + " !!!" );

			// passer au tour suivant
			tour = (tour + 1) % 2;
		}
	}

	private boolean isCoupGagnant( Joueur joueur, int x, int y )
	{
		// horizontal
		if( hasStreak( joueur, 0, y, 1, 0 ) )
			return true;

		// verical
		if( hasStreak( joueur, x, 0, 0, 1 ) )
			return true;

		// diagonale
		if( hasStreak( joueur, 0, 0, 1, 1 ) )
			return true;

		// diagonale
		if( hasStreak( joueur, plateau.getLargeur() - 1, 0, -1, 1 ) )
			return true;

		return false;
	}

	private boolean possedeCaseVide()
	{
		for( int i = 0; i < plateau.getLargeur(); i++ )
			for( int j = 0; j < plateau.getHauteur(); j++ )
				if( plateau.getPiece( i, j ) == null )
					return true;
		return false;
	}

	private boolean hasStreak( Joueur joueur, int x, int y, int vx, int vy )
	{
		while( x >= 0 && x < plateau.getLargeur()
				&& y >= 0 && y < plateau.getHauteur() )
		{
			Piece piece = plateau.getPiece( x, y );
			if( piece == null || piece.getDisplayChar() != joueur.getDisplayChar() )
				return false;

			x += vx;
			y += vy;
		}

		return true;
	}

	Joueur trouverJoueurGagnant()
	{
		for( Joueur joueur : joueurs )
		{
			// le joueur a une horizontale
			for( int i = 0; i < plateau.getHauteur(); i++ )
				if( joueurPossedeHorizontale( joueur, i ) )
					return joueur;
			// le joueur a une verticale
			for( int i = 0; i < plateau.getLargeur(); i++ )
				if( joueurPossedeVerticale( joueur, i ) )
					return joueur;

			// le joueur a une des deux diagonales
			if( joueurPossedeDiagonale1( joueur ) )
				return joueur;

			if( joueurPossedeDiagonale2( joueur ) )
				return joueur;
		}

		return null;
	}

	boolean joueurPossedeHorizontale( Joueur joueur, int y )
	{
		for( int i = 0; i < plateau.getLargeur(); i++ )
		{
			Piece piece = plateau.getPiece( i, y );
			if( piece == null || piece.getDisplayChar() != joueur.getDisplayChar() )
				return false;
		}
		return true;
	}

	boolean joueurPossedeVerticale( Joueur joueur, int x )
	{
		for( int i = 0; i < plateau.getHauteur(); i++ )
		{
			Piece piece = plateau.getPiece( x, i );
			if( piece == null || piece.getDisplayChar() != joueur.getDisplayChar() )
				return false;
		}
		return true;
	}

	boolean joueurPossedeDiagonale1( Joueur joueur )
	{
		for( int i = 0; i < plateau.getLargeur(); i++ )
		{
			Piece piece = plateau.getPiece( i, i );
			if( piece == null || piece.getDisplayChar() != joueur.getDisplayChar() )
				return false;
		}
		return true;
	}

	boolean joueurPossedeDiagonale2( Joueur joueur )
	{
		for( int i = 0; i < plateau.getLargeur(); i++ )
		{
			Piece piece = plateau.getPiece( plateau.getLargeur() - 1 - i, i );
			if( piece == null || piece.getDisplayChar() != joueur.getDisplayChar() )
				return false;
		}
		return true;
	}

}
