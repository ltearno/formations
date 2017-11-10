package fr.lteconsulting.commande.impl.modifdisque;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Disque;
import fr.lteconsulting.outils.Saisie;

public class ModifierTitreOuCodeBarreDisque implements Commande
{
	private Disque disque;

	public ModifierTitreOuCodeBarreDisque( Disque disque )
	{
		this.disque = disque;
	}

	@Override
	public String getNom()
	{
		return "Modifier son code barre ou son titre";
	}

	@Override
	public void executer( ContexteExecution contexte )
	{
		String nouveauNom = Saisie.saisie( "Entrez le nouveau titre (ENTREE pour laisser '" + disque.getNom() + "')" );
		String nouveauCodeBarre = Saisie.saisie( "Entrez le nouveau code barre (ENTREE pour laisser '" + disque.getCodeBarre() + "')" );

		if( nouveauNom != null )
			disque.setNom( nouveauNom );

		if( nouveauCodeBarre != null )
			disque.setCodeBarre( nouveauCodeBarre );

		System.out.println( "Modification effectuée !" );
	}
}