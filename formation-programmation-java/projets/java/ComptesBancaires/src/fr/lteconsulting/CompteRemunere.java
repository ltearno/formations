package fr.lteconsulting;

public class CompteRemunere extends Compte
{
	private double tauxInteret;

	public CompteRemunere( String numeroDeCompte, int soldeInitial, double tauxInteret )
	{
		super( numeroDeCompte, soldeInitial );
		
		this.tauxInteret = tauxInteret;
	}

	public double getTauxInteret()
	{
		return tauxInteret;
	}

	@Override
	public void afficher()
	{
		super.afficher();
		
		System.out.println( "Taux d'interet : " + tauxInteret );
	}
}











