
public class POOBase
{
	/**
	 * Notre programme principal
	 */
	public static void main( String[] args )
	{
		// CREER UNN OBJET Personne
		// c-a-d : avoir une zone mémoire
		// avec la valeur de chaque attribut
		// de l'objet que l'on veut créer...

		// avec l'opérateur 'new'

		// déclaration d'une variable de type Personne
		Personne p; // p vaut null

		p = new Personne();
		p.afficheNomComplet();

		// affectation de la variable 'p' à une référence
		// vers un nouvel objet de la classe Personne
		p = new Personne( "Toto", "Titi", 33000 );

		// appeler la méthode 'affichePersonne' sur l'objet référencé
		// par la variable 'p'
		p.afficheNomComplet();
		
		p.affichePersonne();
		
		System.out.println( "Le code postal de l'objet référencé par p est " + p.getCodePostal() );

		// p ne référence plus aucun objet
//		p = null;
//		p.afficheNomComplet();
	}
}
