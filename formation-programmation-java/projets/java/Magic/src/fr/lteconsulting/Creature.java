package fr.lteconsulting;

public class Creature extends Carte
{
	private String nom;
	private int pointsDegats;
	private int pointsVie;

	public Creature( int cout, String nom, int pointsDegats, int pointsVie )
	{
		super( cout );

		this.nom = nom;
		this.pointsDegats = pointsDegats;
		this.pointsVie = pointsVie;
	}

	@Override
	public void afficher()
	{
		System.out.println( "Une créature " + nom + " " + pointsDegats + "/" + pointsVie );
	}

	public String getNom()
	{
		return nom;
	}

	public int getPointsDegats()
	{
		return pointsDegats;
	}

	public int getPointsVie()
	{
		return pointsVie;
	}

	@Override
	public String toString()
	{
		return "Creature [nom=" + nom + ", pointsDegats=" + pointsDegats + ", pointsVie=" + pointsVie + ", getCout()=" + getCout() + "]";
	}
}
