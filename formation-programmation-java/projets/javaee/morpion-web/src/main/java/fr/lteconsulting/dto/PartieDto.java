package fr.lteconsulting.dto;

public class PartieDto
{
	private boolean tour;
	private Character[][] plateau;

	public PartieDto()
	{
	}

	public PartieDto( int largeur, int hauteur )
	{
		plateau = new Character[hauteur][largeur];
	}

	public boolean isTour()
	{
		return tour;
	}

	public Character[][] getPlateau()
	{
		return plateau;
	}

	public void setPiece( int i, int j, char displayChar )
	{
		plateau[j][i] = displayChar;
	}

	public void setTour( boolean tour )
	{
		this.tour = tour;
	}
}
