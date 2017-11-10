package fr.lteconsulting;

import fr.lteconsulting.commande.Commande;
import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.commande.impl.AffichageDisquesParCodeBarre;
import fr.lteconsulting.commande.impl.AffichageDisquesParNom;
import fr.lteconsulting.commande.impl.AjouterDisque;
import fr.lteconsulting.commande.impl.ChargerFichier;
import fr.lteconsulting.commande.impl.GenerationDisques;
import fr.lteconsulting.commande.impl.Quitter;
import fr.lteconsulting.commande.impl.RechercheParCodeBarre;
import fr.lteconsulting.commande.impl.RechercheParNom;
import fr.lteconsulting.commande.impl.SauvegardeFichier;
import fr.lteconsulting.commande.impl.modifdisque.ModifierDisque;

public class InferfaceUtilisateur
{
	private ContexteExecution contexte;
	private Menu menu = new Menu("Menu principal");

	public InferfaceUtilisateur( ContexteExecution contexte )
	{
		this.contexte = contexte;

		menu.ajouterCommande( new ModifierDisque() );
		menu.ajouterCommande( new AjouterDisque() );
		menu.ajouterCommande( new RechercheParNom() );
		menu.ajouterCommande( new RechercheParCodeBarre() );
		menu.ajouterCommande( new GenerationDisques() );
		menu.ajouterCommande( new AffichageDisquesParNom() );
		menu.ajouterCommande( new AffichageDisquesParCodeBarre() );
		menu.ajouterCommande( new SauvegardeFichier() );
		menu.ajouterCommande( new ChargerFichier() );
		menu.ajouterCommande( new Quitter() );
	}

	public void execute()
	{
		while( true )
		{
			Commande commandeAExecuter = menu.saisirCommmande();

			commandeAExecuter.executer( contexte );
		}
	}
}
