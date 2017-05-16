package fr.lteconsulting;

public class Application
{
	public static void main( String[] args )
	{
		System.out.println( "=== INITIALISATION ===" );

		Compte compte1 = new Compte( "ABC", 3000 );
		Client clt1 = new Client( "Toto", compte1 );

		Compte compte2 = new CompteRemunere( "XYZ", 3000, 0.2 );
		Client clt2 = new Client( "Titi", compte2 );

		Banque banque = new Banque();

		clt1.afficher();
		clt2.afficher();

		System.out.println( "=== TRANSFERT BANCAIRE ===" );

		banque.transferer( clt1, clt2, 123 );

		System.out.println( "=== APRES TRANSFERT ===" );

		clt1.afficher();
		clt2.afficher();

		System.out.println( "=== A LA FIN DE L'ANNEE, VERSEMENT DES INTERETS ===" );

		banque.verserInterets( compte1 );
		banque.verserInterets( compte2 );
		
		clt1.afficher();
		clt2.afficher();
	}
}
