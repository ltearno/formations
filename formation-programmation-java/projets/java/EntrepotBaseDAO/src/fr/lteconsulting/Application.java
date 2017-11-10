package fr.lteconsulting;

import fr.lteconsulting.commandes.AjouterProduit;
import fr.lteconsulting.commandes.ListerEntrepot;
import fr.lteconsulting.commandes.Quitter;
import fr.lteconsulting.commandes.RechercheProduit;
import fr.lteconsulting.dao.ProduitDAO;
import fr.lteconsulting.dao.ProduitDAOMySQL;
import fr.lteconsulting.exception.DAOConfigurationException;

public class Application
{
	public static void main( String[] args )
	{
		try
		{
			ProduitDAO produitDAO = new ProduitDAOMySQL();
			Entrepot entrepot = new Entrepot( produitDAO );
			ContexteCommande contexteExecution = new ContexteCommande( entrepot );

			Menu menu = new Menu();
			menu.ajouterChoix( new ListerEntrepot() );
			menu.ajouterChoix( new AjouterProduit() );
			menu.ajouterChoix( new RechercheProduit() );
			menu.ajouterChoix( new Quitter() );

			while( true )
			{
				Commande commandeChoisie = menu.presenterMenu();
				if( commandeChoisie != null )
				{
					commandeChoisie.executer( contexteExecution );
				}
			}
		}
		catch( DAOConfigurationException e )
		{
			e.printStackTrace();
		}
	}
}
