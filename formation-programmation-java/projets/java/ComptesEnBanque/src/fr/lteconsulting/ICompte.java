package fr.lteconsulting;

public interface ICompte
{
	String getIban();

	double getSolde();

	void modifierSolde( double montant );

	void effectuerOperationsAnnuelles();

	void afficher();
}
