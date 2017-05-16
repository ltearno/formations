
public class DisqueDur
{
	int capacite;

	DisqueDur( int capacite )
	{
		this.capacite = capacite;
	}

	void demarrer()
	{
		System.out.println( "Démarrage DisqueDur de capacité " + capacite );
	}

	void lire()
	{
		System.out.println( "Lecture DisqueDur de capacité " + capacite );
	}

	void eteindre()
	{
		System.out.println( "Extinction DisqueDur de capacité " + capacite );
	}
}
