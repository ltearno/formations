package fr.lteconsulting;

public class Application
{
	public static void main( String[] args )
	{
		Voiture voiture = new Voiture();

		voiture.demarrer();
		voiture.avancer();
		voiture.arreter();

		voiture.avancer();
	}
}
