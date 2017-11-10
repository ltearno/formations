package fr.lteconsulting;

public class Logarithme extends OperationUnaire
{
	public Logarithme( Expression operande )
	{
		super( operande );
	}

	@Override
	public String getDescription()
	{
		return "log(" + operande.getDescription() + ")";
	}

	@Override
	public double getValeur() throws CalculImpossibleException
	{
		return Math.log( operande.getValeur() );
	}
}
