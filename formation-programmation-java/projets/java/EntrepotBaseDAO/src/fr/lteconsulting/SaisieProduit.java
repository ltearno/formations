package fr.lteconsulting;

public class SaisieProduit
{
	public Produit saisieProduit()
	{
		int reference = Saisie.saisieInt( "Référence" );
		String designation = Saisie.saisie( "Désignation" );
		double prixUnitaire = Saisie.saisieDouble( "Prix unitaire" );

		// remplir le produit
		Produit produit = new Produit();
		produit.setReference( reference );
		produit.setDesignation( designation );
		produit.setPrixUnitaire( prixUnitaire );

		return produit;
	}
}
