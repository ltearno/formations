package fr.lteconsulting;

public class Test
{
	public static void main( String[] args )
	{
		Plateau p = new Plateau( 3, 3 );
		Coordonnee c = cherchePiecesAdjacents( p, 'O', 3 );
		System.out.println( "resultat (devrait etre null): " + c );

		p.placerPiece( new Piece( 'O' ), 0, 1 );
		p.placerPiece( new Piece( 'O' ), 1, 1 );
		p.placerPiece( new Piece( 'O' ), 2, 1 );

		c = cherchePiecesAdjacents( p, 'O', 3 );
		System.out.println( "resultat (devrait etre [0,1]): " + c );
	}

	static Coordonnee cherchePiecesAdjacents( Plateau plateau, char displayChar, int nombre )
	{
		for( int j = 0; j < plateau.getHauteur(); j++ )
		{
			for( int i = 0; i <= plateau.getLargeur() - nombre; i++ )
			{
				boolean groupeTrouve = true;

				// on va voir si de [i,j] on a nombre cases avec displayChar
				for( int k = i; k < i + nombre; k++ )
				{
					Piece piece = plateau.getPiece( k, j );
					if( piece == null || piece.getDisplayChar() != displayChar )
					{
						groupeTrouve = false;
						break;
					}
				}

				if( groupeTrouve )
					return new Coordonnee( i, j );
			}
		}

		return null;
	}
}
