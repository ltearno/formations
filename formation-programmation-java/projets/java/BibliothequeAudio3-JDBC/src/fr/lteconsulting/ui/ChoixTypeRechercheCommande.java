package fr.lteconsulting.ui;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;

public class ChoixTypeRechercheCommande implements Commande
{
	private String nom;
	private TypeRecherche typeRecherche;

	private ChoixTypeRecherche choixTypeRecherche;

	public ChoixTypeRechercheCommande( String nom, TypeRecherche typeRecherche, ChoixTypeRecherche choixTypeRecherche )
	{
		this.nom = nom;
		this.typeRecherche = typeRecherche;
		this.choixTypeRecherche = choixTypeRecherche;
	}

	@Override
	public String getNom()
	{
		return nom;
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		choixTypeRecherche.setTypeRecherche( typeRecherche );
	}
}