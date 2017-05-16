package fr.lteconsulting;

public class Voiture
{
	private String couleur;
	private Moteur moteur;
	private Roue[] roues;

	public Voiture()
	{
		moteur = new Moteur();

		roues = new Roue[4];
		for( int i = 0; i < 4; i++ )
			roues[i] = new Roue();
	}

	public void demarrer()
	{
		if( moteur.estDemarre() )
		{
			System.out.println( "La voiture est déjà démarrée" );
			return;
		}

		moteur.demarrer();
		System.out.println( "La voiture est démarée" );
	}

	public void arreter()
	{
		moteur.arreter();
		System.out.println( "La voiture est arrêtée" );
	}

	public void avancer()
	{
		if( moteur.estDemarre() )
		{
			for( Roue roue : roues )
				roue.rouler();

			System.out.println( "La voiture avance" );
		}
		else
		{
			System.out.println( "Le moteur est éteint, impossible d'avancer" );
		}
	}
}
