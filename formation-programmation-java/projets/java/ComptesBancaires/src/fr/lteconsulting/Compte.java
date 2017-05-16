package fr.lteconsulting;

public class Compte
{
	private String numeroDeCompte;
	private double solde;

	public Compte( String numeroDeCompte, int soldeInitial )
	{
		this.numeroDeCompte = numeroDeCompte;
		solde = soldeInitial;
	}

	public double getSolde()
	{
		return solde;
	}

	public String getNumeroDeCompte()
	{
		return numeroDeCompte;
	}

	public void afficher()
	{
		System.out.println( "Compte '" + numeroDeCompte + "'" );
		System.out.println( "Avoir disponible : " + solde );
	}

	public void debiter( double montant )
	{
		System.out.println( "-> débit de " + montant + " sur compte " + numeroDeCompte );
		
		solde -= montant;
	}

	public void crediter( double montant )
	{
		System.out.println( "-> crédit de " + montant + " sur compte " + numeroDeCompte );
		solde += montant;
	}
}















