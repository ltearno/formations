package fr.lteconsulting;

public class ContexteCommande
{
	private Entrepot entrepot;

	public ContexteCommande( Entrepot entrepot )
	{
		this.entrepot = entrepot;
	}

	public Entrepot getEntrepot()
	{
		return entrepot;
	}
}
