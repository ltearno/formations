package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Disque;
import fr.lteconsulting.Saisie;

public class ChangerCodeBarreCommande extends CommandeBase
{
	public ChangerCodeBarreCommande()
	{
		super( "Changer code barre d'un disque" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.println( "\n## CHANGER CODE BARRE DISQUE ##\n" );
		String codeBarre = Saisie.saisie( "Saisissez le code barre du disque à modifier" );
		Disque disque = contexte.getBibliotheque().getDisque( codeBarre );
		if( disque == null )
		{
			System.out.println( "Aucun disque trouvé..." );
		}
		else
		{
			String nouveauCodeBarre = Saisie.saisie( "Saisissez le nouveau code barre" );
			disque.setCodeBarre( nouveauCodeBarre );
		}
	}
}
