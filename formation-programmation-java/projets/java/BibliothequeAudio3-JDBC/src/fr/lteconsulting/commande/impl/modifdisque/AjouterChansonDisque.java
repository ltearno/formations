package fr.lteconsulting.commande.impl.modifdisque;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.ui.OutilsSaisie;

public class AjouterChansonDisque implements Commande
{
	private Disque disque;

	public AjouterChansonDisque( Disque disque )
	{
		this.disque = disque;
	}

	@Override
	public String getNom()
	{
		return "Ajouter une chanson";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		// TODO : on devrait aussi pouvoir spécifier la position d'insertion

		Chanson chanson = OutilsSaisie.saisirChanson();
		if( chanson != null )
			disque.addChanson( chanson );
	}
}