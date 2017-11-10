package fr.lteconsulting.commande.impl;

import java.util.UUID;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;
import fr.lteconsulting.ui.OutilsSaisie;

public class AjouterDisque implements Commande
{
	@Override
	public String getNom()
	{
		return "Ajouter un disque";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		String nom = Saisie.saisie( "Nom du disque" );
		String codeBarre = Saisie.saisie( "Code barre (laisser vide pour génération aléatoire)" );
		if( codeBarre.isEmpty() )
			codeBarre = UUID.randomUUID().toString();

		Disque disque = new Disque( codeBarre, nom );

		while( true )
		{
			Chanson chanson = OutilsSaisie.saisirChanson();
			if( chanson == null )
				break;

			disque.addChanson( chanson );
		}

		contexte.getBibliotheque().ajouterDisque( disque );
	}
}
