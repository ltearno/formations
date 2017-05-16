package fr.lteconsulting.bidon;

import fr.lteconsulting.Piece;

public class Dame implements Piece
{
	private CouleurNB couleur;

	public Dame( CouleurNB couleur )
	{
		this.couleur = couleur;
	}

	@Override
	public char getDisplayChar()
	{
		return couleur.getDisplayChar();
	}

}
