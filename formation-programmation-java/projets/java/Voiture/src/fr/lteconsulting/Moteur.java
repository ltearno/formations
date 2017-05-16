package fr.lteconsulting;

public class Moteur
{
	private int puissance;
	private boolean enMarche;

	public void demarrer()
	{
		if( enMarche )
		{
			System.out.println( "Crrr" );
		}
		else
		{
			System.out.println( "Le moteur démarre" );
			enMarche = true;
		}
	}

	public void arreter()
	{
		if( enMarche )
		{
			System.out.println( "Le moteur s'arrête" );
			enMarche = false;
		}
		else
		{
			System.out.println( "Le moteur est déjà éteint" );
		}
	}

	public boolean estDemarre()
	{
		return enMarche;
	}
}
