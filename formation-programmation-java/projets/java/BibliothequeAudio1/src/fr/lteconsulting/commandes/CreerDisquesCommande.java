package fr.lteconsulting.commandes;

import java.util.Random;
import java.util.UUID;

import fr.lteconsulting.ApplicationContext;
import fr.lteconsulting.Chanson;
import fr.lteconsulting.Disque;
import fr.lteconsulting.DisqueDejaPresentException;
import fr.lteconsulting.Mots;
import fr.lteconsulting.Saisie;

public class CreerDisquesCommande extends CommandeBase
{
	public CreerDisquesCommande()
	{
		super( "Créer des disques au hasard" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		int nbDisques = Saisie.saisieInt( "Combien de disques voulez-vous créer ?" );
		while( nbDisques-- > 0 )
		{
			try
			{
				contexte.getBibliotheque().ajouterDisque( creerDisque() );
			}
			catch( DisqueDejaPresentException e )
			{
				System.out.println( "Duplication de code barre ! C'est pas grave va..." );
			}
		}
	}

	private Disque creerDisque()
	{
		Disque disque = new Disque( Mots.phrase(), UUID.randomUUID().toString() );

		int nbChansons = 3 + new Random().nextInt( 10 );

		while( nbChansons-- > 0 )
			disque.addChanson( creerChanson() );

		return disque;
	}

	private Chanson creerChanson()
	{
		return new Chanson( Mots.phrase(), 30 + new Random().nextInt( 60 ) );
	}
}
