package fr.lteconsulting;

import java.io.Serializable;
import java.util.Random;

public class Plateau implements Serializable
{
	private static final long serialVersionUID = -4675149630860404721L;

	private Piece[][] damier;
	private int largeur;
	private int hauteur;

	public Plateau( int largeur, int hauteur )
	{
		this.largeur = largeur;
		this.hauteur = hauteur;

		damier = new Piece[largeur][hauteur];
	}

	public void placerPiece( Piece piece, int x, int y )
	{
		damier[x][y] = piece;
	}

	public Piece getPiece( int x, int y )
	{
		return damier[x][y];
	}

	public int getLargeur()
	{
		return largeur;
	}

	public int getHauteur()
	{
		return hauteur;
	}

	public void afficher()
	{
		for( int j = 0; j < hauteur; j++ )
		{
			String ligne = "";
			for( int i = 0; i < largeur; i++ )
			{
				Piece piece = damier[i][j];
				if( piece == null )
					ligne += ".";
				else
					ligne += piece.getDisplayChar();
			}
			System.out.println( ligne );
		}
	}

	public void initialiserHasard()
	{
		// parcourir toutes les cases
		// parfois on va ne rien mettre
		// parfois on va mettre un O
		// parfois on va mettre un X
		for( int i = 0; i < largeur; i++ )
		{
			for( int j = 0; j < hauteur; j++ )
			{
				Random random = new Random();
				int de = random.nextInt( 3 );
				switch( de )
				{
					case 1:
						damier[i][j] = new Piece( 'O' );
						break;

					case 2:
						damier[i][j] = new Piece( 'X' );
						break;
				}
			}
		}
	}
}
