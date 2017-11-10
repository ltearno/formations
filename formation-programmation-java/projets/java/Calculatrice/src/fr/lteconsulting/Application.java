package fr.lteconsulting;

import javax.swing.plaf.multi.MultiButtonUI;

import fr.lteconsulting.operations.binaire.Addition;
import fr.lteconsulting.operations.binaire.Division;
import fr.lteconsulting.operations.binaire.Multiplication;

public class Application
{
	public static void main( String[] args )
	{
		Calculatrice calculatrice = new Calculatrice();

		Expression operation = new Addition( new Valeur( 3 ), new Valeur( 3 ) );
		calculatrice.effectuerCalcul( operation );

		calculatrice.effectuerCalcul( new Division( new Valeur( 3 ), new Valeur( 0 ) ) );

		// 2*5 + 3

		Expression deuxFoisCinq = new Multiplication( new Valeur( 2 ), new Valeur( 5 ) );
		Expression deuxFoisCinqPlusTrois = new Addition( deuxFoisCinq, new Valeur( 3 ) );

		calculatrice.effectuerCalcul( deuxFoisCinqPlusTrois );

		calculatrice.effectuerCalcul(
				new Addition(
						new Logarithme(
								new Multiplication(
										new Valeur( 2 ),
										new Valeur( 5 ) ) ),
						new Valeur( 3 ) ) );

	}
}
