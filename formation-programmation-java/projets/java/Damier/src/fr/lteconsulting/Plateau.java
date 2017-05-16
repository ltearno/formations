package fr.lteconsulting;

/**
 * Un plateau est une grille (à deux dimensions) contenant des {@link Piece}.
 */
public class Plateau<T extends Piece>
{
	/**
	 * La première dimension représente les ordonnées et la deuxième les abscisses
	 */
	private T[][] damier;

	private int largeur;

	@SuppressWarnings( "unchecked" )
	public Plateau( int largeur, int hauteur )
	{
		this.largeur = largeur;

		damier = (T[][]) new Piece[hauteur][largeur];
	}

	public void afficher()
	{
		System.out.println();

		afficherBordHaut();

		afficherEchelleHorizontaleRomaine();

		for( int l = 0; l < damier.length; l++ )
		{
			T[] ligne = damier[l];

			System.out.print( "| " );

			int numeroLigne = l + 1;
			System.out.printf( "%2d ", numeroLigne );

			for( T piece : ligne )
			{
				if( piece == null )
					System.out.print( "." );
				else
					System.out.print( piece.getDisplayChar() );
			}

			System.out.printf( " %2d |", numeroLigne );

			System.out.println();
		}

		afficherEchelleHorizontaleNaturelle();

		afficherBordBas();
	}

	public void placer( T piece, Coordonnee coordonnee )
	{
		damier[coordonnee.getY()][coordonnee.getX()] = piece;
	}

	public T getPieceAt( Coordonnee coordonnee )
	{
		return damier[coordonnee.getY()][coordonnee.getX()];
	}

	public boolean estPlein()
	{
		for( T[] ligne : damier )
			for( T piece : ligne )
				if( piece == null )
					return false;
		
		return true;
	}
	
	public boolean possedeCasesVides()
	{
		return ! estPlein();
	}

	public Coordonnee getCoordonneesDePiece( Piece piece )
	{
		for( int indexLigne = 0; indexLigne < damier.length; indexLigne++ )
		{
			T[] ligne = damier[indexLigne];
			for( int indexColonne = 0; indexColonne < ligne.length; indexColonne++ )
			{
				T p = ligne[indexColonne];
				if( p == piece )
					return new Coordonnee( indexColonne, indexColonne );
			}
		}

		return null;
	}

	private void afficherBordHaut()
	{
		System.out.print( "/" );
		for( int i = 0; i < 8 + largeur; i++ )
			System.out.print( "-" );
		System.out.println( "\\" );
	}

	private void afficherBordBas()
	{
		System.out.print( "\\" );
		for( int i = 0; i < 8 + largeur; i++ )
			System.out.print( "-" );
		System.out.println( "/" );
	}

	private void afficherEchelleHorizontaleRomaine()
	{
		System.out.print( "|    " );
		for( int i = 0; i < largeur; i++ )
		{
			int dizaine = i / 26;
			System.out.print( (char) ('A' + dizaine) );
		}
		System.out.println( "    |" );

		System.out.print( "|    " );
		for( int i = 0; i < largeur; i++ )
		{
			int unite = i % 26;
			System.out.print( (char) ('A' + unite) );
		}
		System.out.println( "    |" );
	}

	private void afficherEchelleHorizontaleNaturelle()
	{
		System.out.print( "|    " );
		for( int i = 1; i <= largeur; i++ )
		{
			int dizaine = i / 10;

			System.out.printf( "%1d", dizaine );
		}
		System.out.println( "    |" );

		System.out.print( "|    " );
		for( int i = 1; i <= largeur; i++ )
		{
			int unite = i % 10;

			System.out.printf( "%1d", unite );
		}
		System.out.println( "    |" );
	}
}
