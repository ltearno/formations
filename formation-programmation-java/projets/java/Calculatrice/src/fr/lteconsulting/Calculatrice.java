package fr.lteconsulting;

public class Calculatrice
{
	public void effectuerCalcul( Expression operation )
	{
		try
		{
			System.out.println( "DEBUT DU CALCUL DE " + operation.getDescription() );

			double resultat = operation.getValeur();

			System.out.println( "RESULTAT : " + resultat );
		}
		catch( CalculImpossibleException e )
		{
			System.out.println( "CALCUL IMPOSSIBLE CAR " + e.getMessage() );
		}
	}
}
