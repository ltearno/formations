package fr.lteconsulting;

public abstract class OperationUnaire implements Expression
{
	protected Expression operande;

	public OperationUnaire( Expression operande )
	{
		this.operande = operande;
	}
}
