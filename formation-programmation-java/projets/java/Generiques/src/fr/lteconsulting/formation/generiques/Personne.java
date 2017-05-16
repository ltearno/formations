package fr.lteconsulting.formation.generiques;

/**
 * Représente non pas UNE personne mais TOUTES les personnes.
 */
public class Personne
{
	// Les attributs
	String nom;
	String prenom;
	int codePostal;

	// le constructeur par défaut
	// généré automatiquement par Java
	// si vous n'écrivez pas de constructeur explicitement
	Personne()
	{
	}

	// Un constructeur.
	// si j'écit new Personne( "toto", "titi" )
	// -> une zone mémoire est allouée pour contenir les données du nouvel objet
	// -> le constructeur est appelé pour initialiser l'objet
	Personne( String nom, String prenom, int codePostal )
	{
		this.nom = nom;
		this.prenom = prenom;
		this.codePostal = codePostal;
	}

	// en Java on appelle ça un 'getter' ('accesseur')
	int getCodePostal()
	{
		return codePostal;
	}

	// retourne el nom complet : NOM ' ' PRENOM
	String getNomComplet()
	{
		return nom + " " + prenom;
	}

	// Les méthodes, c-a-d le code qui manipule les attributs
	void demenage( int nouveauCodePostal )
	{
		// on modifie l'attribut 'codePostal'
		codePostal = nouveauCodePostal;
	}

	void affichePersonne()
	{
		System.out.println( getNomComplet() + "\n" + codePostal );
	}

	void afficheNomComplet()
	{
		System.out.println( getNomComplet() );
	}
}
