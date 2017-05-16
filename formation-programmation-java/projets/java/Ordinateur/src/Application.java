
public class Application
{
	public static void main( String[] args )
	{
		Ordinateur o = new Ordinateur(
				"Toto-43",
				128,
				new int[] { 40, 123, 2525, 334, 4444, 250, 250 } );
		o.allumer();

		/*
		 * ca doit afficher
		 * 
		 * Ordinateur démarre
		 * Initialisation mémoire
		 * Démarrage DisqueDur de capacité 40
		 * Démarrage DisqueDur de capacité 250
		 * Démarrage DisqueDur de capacité 250
		 * Lecture DisqueDur
		 * 
		 */

		o.eteindre();

		/*
		 * ca doit afficher
		 * 
		 * Extinction DisqueDur de capacité 250
		 * Extinction DisqueDur de capacité 250
		 * Extinction DisqueDur de capacité 40
		 * Extinction MemoireVive
		 * L'ordinateur est éteint
		 * 
		 */
	}
}
