package fr.lteconsulting;

import fr.lteconsulting.commande.ContexteExecution;
import fr.lteconsulting.modele.Bibliotheque;

public class Application
{
	public static void main( String[] args )
	{
		Bibliotheque bibliotheque = new Bibliotheque();

		ContexteExecution contexteExecution = new ContexteExecution( bibliotheque, "bibliotheque.data" );

		InferfaceUtilisateur ui = new InferfaceUtilisateur( contexteExecution );

		ui.execute();
	}
}
