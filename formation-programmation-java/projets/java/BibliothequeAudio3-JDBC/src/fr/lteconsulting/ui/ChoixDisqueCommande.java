package fr.lteconsulting.ui;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;

public class ChoixDisqueCommande implements Commande
{
	private ChoixDisque choix;

	private Disque disqueASelectionner;

	public ChoixDisqueCommande( Disque disqueASelectionner, ChoixDisque choix )
	{
		this.disqueASelectionner = disqueASelectionner;
		this.choix = choix;
	}

	@Override
	public String getNom()
	{
		return disqueASelectionner.getNom();
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		choix.setDisque( disqueASelectionner );
	}
}