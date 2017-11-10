package fr.lteconsulting.operations.binaire;

import fr.lteconsulting.CalculImpossibleException;
import fr.lteconsulting.Expression;
import fr.lteconsulting.OperationBinaire;

public class Multiplication extends OperationBinaire
{
	public Multiplication( Expression operandeGauche, Expression operandeDroite )
	{
		super( operandeGauche, operandeDroite );
	}

	@Override
	protected String getOperateur()
	{
		return "x";
	}

	@Override
	public double getValeur() throws CalculImpossibleException
	{
		return operandeGauche.getValeur() * operandeDroite.getValeur();
	}
}
