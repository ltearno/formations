package fr.lteconsulting.commandes;

import java.util.UUID;

import fr.lteconsulting.Commande;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class AjouterDisque implements Commande
{
	private Bibliotheque bibliotheque;

	public AjouterDisque( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom()
	{
		return "Ajouter un disque";
	}

	@Override
	public void executer()
	{
		String nom = Saisie.saisie( "Nom du disque" );
		String codeBarre = Saisie.saisie( "Code barre (laisser vide pour génération aléatoire)" );
		if( codeBarre.isEmpty() )
			codeBarre = UUID.randomUUID().toString();

		Disque disque = new Disque( codeBarre, nom );

		while( true )
		{
			String titre = Saisie.saisie( "Nom de la chanson (laisser vide pour terminer)" );
			if( titre.isEmpty() )
				break;

			int duree = Saisie.saisieInt( "Durée de la chanson" );

			Chanson chanson = new Chanson( titre, duree );
			disque.addChanson( chanson );
		}

		bibliotheque.ajouterDisque( disque );
	}
}
