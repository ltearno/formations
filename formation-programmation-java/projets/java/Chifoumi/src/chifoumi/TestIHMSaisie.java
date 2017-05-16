package chifoumi;

public class TestIHMSaisie
{
	public static void main( String[] arg )
	{
		IHMSaisie saisie = new IHMSaisie( "toto" );
		Choix choix = saisie.proposerChoix();
		System.out.println( "Le choix de toto est " + choix );
	}
}