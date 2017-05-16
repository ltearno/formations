package fr.lteconsulting;

import java.util.HashMap;
import java.util.Map;

public class Banque
{
	private Map<String, ICompte> comptes = new HashMap<>();

	public void ajouterCompte( ICompte compte )
	{
		System.out.println( "AJOUT DU COMPTE " + compte.getIban() );
		comptes.put( compte.getIban(), compte );
	}

	public void effectuerVirement( String ibanDebiteur, String ibanCrediteur, double montant )
			throws CompteInexistantException
	{
		System.out.println();
		System.out.println( "VIREMENT DE " + ibanDebiteur + " VERS " + ibanCrediteur + " D'UN MONTANT DE " + montant );

		ICompte debiteur = comptes.get( ibanDebiteur );
		if( debiteur == null )
			throw new CompteInexistantException( "DEBITEUR", ibanDebiteur );

		ICompte crediteur = comptes.get( ibanCrediteur );
		if( crediteur == null )
			throw new CompteInexistantException( "CREDITEUR", ibanCrediteur );

		debiteur.modifierSolde( -montant );
		crediteur.modifierSolde( montant );
	}

	public void effectuerOperationsAnnuelles()
	{
		System.out.println();
		System.out.println( "TRAITEMENT DES OPERATIONS ANNUELLES" );
		for( ICompte compte : comptes.values() )
			compte.effectuerOperationsAnnuelles();
	}

	public void bilan()
	{
		System.out.println();
		System.out.println( "BILAN DE LA BANQUE" );
		for( ICompte compte : comptes.values() )
			compte.afficher();
	}
}
