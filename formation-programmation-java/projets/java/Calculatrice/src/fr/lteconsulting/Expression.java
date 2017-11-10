package fr.lteconsulting;

public interface Expression
{
	double getValeur() throws CalculImpossibleException;
	
	String getDescription();
}
