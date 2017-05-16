
public class Imprimante
{
	int encreRestante;

	Imprimante( int capacite )
	{
		encreRestante = capacite;
	}

	void imprimer( String texte )
	{
		if( encreRestante < texte.length() )
			System.out.println( "Y A PLPUS D'ENCRE!!!" );
		else
			encreRestante -= texte.length();
	}

	void afficherStatut()
	{
		System.out.println( "De l'encre, il en reste " + encreRestante );
	}
}
