package fr.lteconsulting.commandes;

import fr.lteconsulting.Commande;
import fr.lteconsulting.ContexteCommande;

public class ListerEntrepot implements Commande
{
	@Override
	public String getTitre()
	{
		return "Afficher le contenu du stock";
	}

	@Override
	public void executer( ContexteCommande contexte )
	{
		contexte.getEntrepot().afficherStock();
	}
}
