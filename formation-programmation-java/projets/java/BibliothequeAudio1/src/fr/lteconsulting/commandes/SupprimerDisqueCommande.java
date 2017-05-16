package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Saisie;

public class SupprimerDisqueCommande extends CommandeBase
{
	public SupprimerDisqueCommande()
	{
		super( "Supprimer un disque" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "\n## SUPPRIMER UN DISQUE ##\n" );
		String codeBarre = Saisie.saisie( "Saisissez le code barre du dsique à afficher" );
		boolean suppressionOk = contexte.getBibliotheque().retirerDisque( codeBarre );
		if( suppressionOk )
			System.out.printf( "Disque '%s' supprimé\n", codeBarre );
		else
			System.out.println( "Aucun disque trouvé..." );
	}
}
