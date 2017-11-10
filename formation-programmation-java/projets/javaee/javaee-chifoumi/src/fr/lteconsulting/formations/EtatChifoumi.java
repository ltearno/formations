package fr.lteconsulting.formations;

public class EtatChifoumi
{
	private int scoreJoueur;
	private int scoreOrdinateur;

	public int getScoreJoueur()
	{
		return scoreJoueur;
	}

	public void incrementeJoueur()
	{
		scoreJoueur++;
	}

	public int getScoreOrdinateur()
	{
		return scoreOrdinateur;
	}

	public void incrementeOrdinateur()
	{
		scoreOrdinateur++;
	}
}
