package fr.lteconsulting.commandes;

import fr.lteconsulting.Commande;
import fr.lteconsulting.GenerateurDisque;
import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class GenerationDisques implements Commande
{
	private Bibliotheque bibliotheque;

	public GenerationDisques( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom()
	{
		return "Générer des disques au hasard";
	}

	@Override
	public void executer()
	{
		int nbDisques = Saisie.saisieInt( "Combien de disques voulez-vous générer?" );
		if( nbDisques <= 0 )
			return;

		System.out.println( "Génération des disques :" );

		GenerateurDisque generateur = new GenerateurDisque();
		while( nbDisques-- > 0 )
		{
			Disque disque = generateur.genererDisque();

			disque.afficher( false );

			bibliotheque.ajouterDisque( disque );
		}
	}
}
