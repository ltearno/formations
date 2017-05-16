package fr.lteconsulting.formations;

public class Employe extends Personne
{
	private String entreprise;

	public Employe( String nom, String prenom, int codePostal, String entreprise )
	{
		super( nom, prenom, codePostal );
		this.entreprise = entreprise;
	}

	public String getEntreprise()
	{
		return entreprise;
	}

	@Override
	public String toString()
	{
		return super.toString() + " " + entreprise;
	}
}
