package fr.lteconsulting;

public abstract class OperationBinaire implements Expression
{
	protected Expression operandeGauche;
	protected Expression operandeDroite;

	abstract protected String getOperateur();

	public OperationBinaire( Expression operandeGauche, Expression operandeDroite )
	{
		this.operandeGauche = operandeGauche;
		this.operandeDroite = operandeDroite;
	}

	@Override
	public String getDescription()
	{
		return "("
				+ operandeGauche.getDescription()
				+ getOperateur()
				+ operandeDroite.getDescription()
				+ ")";
	}
}
