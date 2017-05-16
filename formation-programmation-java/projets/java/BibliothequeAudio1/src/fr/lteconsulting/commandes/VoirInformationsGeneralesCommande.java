package fr.lteconsulting.commandes;

import fr.lteconsulting.ApplicationContext;

public class VoirInformationsGeneralesCommande extends CommandeBase
{
	public VoirInformationsGeneralesCommande()
	{
		super( "Informations générales" );
	}

	@Override
	public void executer( ApplicationContext contexte )
	{
		System.out.printf( "La bibliothèque contient %d disques\n", contexte.getBibliotheque().getNbDisques() );
	}
}
