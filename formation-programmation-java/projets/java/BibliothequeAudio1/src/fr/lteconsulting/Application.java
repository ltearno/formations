package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.commandes.ChangerCodeBarreCommande;
import fr.lteconsulting.commandes.ChargerBibliothequeCommande;
import fr.lteconsulting.commandes.CreerDisquesCommande;
import fr.lteconsulting.commandes.EnregistrerBibliothequeCommande;
import fr.lteconsulting.commandes.ListeDisquesCommande;
import fr.lteconsulting.commandes.QuitterCommande;
import fr.lteconsulting.commandes.RechercherChansonsCommande;
import fr.lteconsulting.commandes.RechercherDisquesCommande;
import fr.lteconsulting.commandes.SupprimerDisqueCommande;
import fr.lteconsulting.commandes.VoirDetailDisqueCommande;
import fr.lteconsulting.commandes.VoirInformationsGeneralesCommande;

public class Application
{
	public static void main( String[] args )
	{
		run();
	}

	static void run()
	{
		ApplicationContext contexte = new ApplicationContext();
		contexte.setBibliotheque( new Bibliotheque() );

		System.out.println( "Initialisation OK..." );

		menuPrincipal( contexte );
	}

	static void menuPrincipal( ApplicationContext contexte )
	{
		List<ICommande> commandes = new ArrayList<>();

		commandes.add( new CreerDisquesCommande() );
		commandes.add( new ListeDisquesCommande() );
		commandes.add( new VoirInformationsGeneralesCommande() );
		commandes.add( new SupprimerDisqueCommande() );
		commandes.add( new RechercherDisquesCommande() );
		commandes.add( new RechercherChansonsCommande() );
		commandes.add( new VoirDetailDisqueCommande() );
		commandes.add( new ChangerCodeBarreCommande() );
		commandes.add( new EnregistrerBibliothequeCommande() );
		commandes.add( new ChargerBibliothequeCommande() );
		commandes.add( new QuitterCommande() );

		while( true )
		{
			ICommande commandeAExecuter = Saisie.saisieMenu( "MENU PRINCIPAL", commandes );

			commandeAExecuter.executer( contexte );
		}
	}
}
