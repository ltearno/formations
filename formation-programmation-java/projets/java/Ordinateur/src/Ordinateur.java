
public class Ordinateur
{
	String modele;
	MemoireVive memoire;
	DisqueDur[] disquesDurs;

	Ordinateur( String modele, int capaciteMemoire, int[] capaciteDisquesDurs )
	{
		this.modele = modele;

		memoire = new MemoireVive( capaciteMemoire );

		int nbDisqueDurs = capaciteDisquesDurs.length;

		disquesDurs = new DisqueDur[nbDisqueDurs];
		for( int i = 0; i < nbDisqueDurs; i++ )
			disquesDurs[i] = new DisqueDur( capaciteDisquesDurs[i] );
	}

	void allumer()
	{
		System.out.println( "Ordinateur démarre" );

		// - on initialise la mémoire,
		memoire.initialiser();

		// - on démarre tous les disques durs
		for( int i = 0; i < disquesDurs.length; i++ )
			disquesDurs[i].demarrer();

		// - on lit dans le premier disque dur
		disquesDurs[0].lire();
	}

	void eteindre()
	{
		for( int i = disquesDurs.length - 1; i >= 0; i-- )
			disquesDurs[i].eteindre();

		memoire.eteindre();

		System.out.println( "L'ordinateur est éteint" );
	}
}
