package fr.lteconsulting.commandes;

import fr.lteconsulting.ICommande;

public abstract class CommandeBase implements ICommande
{
	private String titre;

	protected CommandeBase( String titre )
	{
		this.titre = titre;
	}

	@Override
	public String getTitre()
	{
		return titre;
	}
}
