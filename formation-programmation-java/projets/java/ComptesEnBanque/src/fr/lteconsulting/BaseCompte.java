package fr.lteconsulting;

public class BaseCompte
{
	private String iban;
	private double solde;

	public BaseCompte( String iban, double solde )
	{
		this.iban = iban;
		this.solde = solde;
	}

	public String getIban()
	{
		return iban;
	}

	public double getSolde()
	{
		return solde;
	}

	public void modifierSolde( double montant )
	{
		solde += montant;
	}
}
