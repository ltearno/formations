package fr.lteconsulting.commande;

import fr.lteconsulting.modele.Bibliotheque;

/**
 * Embarque les informations nécessaires à l'exécution d'une commande
 * 
 * @author Arnaud
 *
 */
public class ContexteExecution
{
	private Bibliotheque bibliotheque;
	private String dataFilePath;

	public ContexteExecution( Bibliotheque bibliotheque, String dataFilePath )
	{
		this.bibliotheque = bibliotheque;
		this.dataFilePath = dataFilePath;
	}

	public Bibliotheque getBibliotheque()
	{
		return bibliotheque;
	}

	public String getDataFilePath()
	{
		return dataFilePath;
	}
}
