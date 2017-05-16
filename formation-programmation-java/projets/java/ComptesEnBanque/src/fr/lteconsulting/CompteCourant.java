package fr.lteconsulting;

public class CompteCourant extends BaseCompte implements ICompte
{
	public CompteCourant( String iban, double solde )
	{
		super( iban, solde );
	}

	@Override
	public void effectuerOperationsAnnuelles()
	{
		System.out.println( "Pas d'opération annuelle sur le compte courant " + getIban() );
	}

	@Override
	public void afficher()
	{
		System.out.println( "Compte courant " + getIban() + " solde: " + getSolde() );
	}
}
