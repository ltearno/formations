package fr.lteconsulting.operations.binaire;

import fr.lteconsulting.CalculImpossibleException;
import fr.lteconsulting.Expression;
import fr.lteconsulting.OperationBinaire;

public class Division extends OperationBinaire
{
	public Division( Expression operandeGauche, Expression operandeDroite )
	{
		super( operandeGauche, operandeDroite );
	}

	@Override
	protected String getOperateur()
	{
		return "/";
	}

	@Override
	public double getValeur() throws CalculImpossibleException
	{
		if( operandeDroite.getValeur() == 0 )
			throw new CalculImpossibleException( "DIVISION PAR ZERO" );

		return operandeGauche.getValeur() / operandeDroite.getValeur();
	}
}
