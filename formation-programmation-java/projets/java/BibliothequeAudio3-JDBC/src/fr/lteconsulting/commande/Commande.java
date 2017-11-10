package fr.lteconsulting.commande;

public interface Commande
{
	String getNom();

	void executer( ContexteExecution contexte );
}
