package fr.lteconsulting.commandes;

import fr.lteconsulting.Commande;
import fr.lteconsulting.Produit;
import fr.lteconsulting.SaisieProduit;

public class AjouterProduit implements Commande
{
	@Override
	public String getTitre()
	{
		return "Ajouter un produit";
	}

	public void executer( fr.lteconsulting.ContexteCommande contexte )
	{
		SaisieProduit saisie = new SaisieProduit();
		Produit produit = saisie.saisieProduit();
		if( produit == null )
		{
			System.out.println( "Saisie invalide, impossible d'ajouter le produit" );
			return;
		}

		contexte.getEntrepot().ajouterProduit( produit );
	};
}
