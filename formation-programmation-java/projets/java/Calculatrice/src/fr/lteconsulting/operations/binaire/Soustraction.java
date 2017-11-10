package fr.lteconsulting.operations.binaire;

import fr.lteconsulting.CalculImpossibleException;
import fr.lteconsulting.Expression;
import fr.lteconsulting.OperationBinaire;

public class Soustraction extends OperationBinaire
{
	public Soustraction( Expression operandeGauche, Expression operandeDroite )
	{
		super( operandeGauche, operandeDroite );
	}

	@Override
	protected String getOperateur()
	{
		return "-";
	}

	@Override
	public double getValeur() throws CalculImpossibleException
	{
		return operandeGauche.getValeur() - operandeDroite.getValeur();
	}
}
