package fr.lteconsulting;

public interface Commande
{
	void executer( ContexteCommande contexte );

	String getTitre();
}
