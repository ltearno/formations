
@SuppressWarnings( "serial" )
public class ExceptionNegatif extends Exception
{
	int valeur;

	ExceptionNegatif( int val )
	{
		valeur = val;
	}

	public String toString()
	{
		return valeur + " est  négatif";
	}
}