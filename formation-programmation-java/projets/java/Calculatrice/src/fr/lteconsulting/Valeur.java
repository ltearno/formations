package fr.lteconsulting;

public class Valeur implements Expression
{
	double valeur;

	public Valeur( double valeur )
	{
		this.valeur = valeur;
	}

	@Override
	public String getDescription()
	{
		return String.valueOf( valeur );
	}

	@Override
	public double getValeur()
	{
		return valeur;
	}
}
