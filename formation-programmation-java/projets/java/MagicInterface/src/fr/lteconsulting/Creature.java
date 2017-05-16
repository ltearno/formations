package fr.lteconsulting;

public class Creature extends BaseCarte implements ICarte
{
	private String nom;
	private int degats;
	private int vie;

	public Creature( int cout, String nom, int degats, int vie )
	{
		super( cout );

		this.nom = nom;
		this.degats = degats;
		this.vie = vie;
	}

	@Override
	public void afficher()
	{
		System.out.println( "Une créature " + nom + " " + degats + "/" + vie );
	}
}
