package fr.lteconsulting;

public class CompteRemunere extends BaseCompte implements ICompte
{
	private double tauxRemuneration;

	public CompteRemunere( String iban, double solde, double tauxRemuneration )
	{
		super( iban, solde );
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public void effectuerOperationsAnnuelles()
	{
		double interets = getSolde() * tauxRemuneration;
		double ancienSolde = getSolde();
		modifierSolde( interets );

		System.out.println( "Compte rémunéré " + getIban() + ", opération annuelle" );
		System.out.println( "  Les intérêts s'élèvent à " + interets );
		System.out.println( "  Le nouveau solde est " + getSolde() + " (ancien solde:" + ancienSolde + ")" );
	}

	@Override
	public void afficher()
	{
		System.out.println( "Compte rémunéré au taux " + tauxRemuneration + " " + getIban() + " solde: " + getSolde() );
	}
}
