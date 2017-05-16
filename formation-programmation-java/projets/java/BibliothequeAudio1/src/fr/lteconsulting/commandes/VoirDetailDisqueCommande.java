package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Disque;
import fr.lteconsulting.ICommande;
import fr.lteconsulting.Saisie;

public class VoirDetailDisqueCommande implements ICommande
{
	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "\n## DETAILS DISQUE ##\n" );
		String codeBarre = Saisie.saisie( "Saisissez le code barre du dsique à afficher" );
		Disque disque = contexte.getBibliotheque().getDisque( codeBarre );
		if( disque == null )
		{
			System.out.println( "Aucun disque trouvé..." );
		}
		else
		{
			System.out.println( "Disque trouvé, affichage des détails :" );
			disque.afficher();
		}
	}

	@Override
	public String getTitre()
	{
		return "Voir détails disque";
	}
}
