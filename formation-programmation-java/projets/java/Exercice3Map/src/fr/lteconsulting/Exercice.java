package fr.lteconsulting;

public class Exercice
{
	private String intitule;
	private String sujet;

	public Exercice( String intitule, String sujet )
	{
		this.intitule = intitule;
		this.sujet = sujet;
	}

	public String getIntitule()
	{
		return intitule;
	}

	public void setIntitule( String intitule )
	{
		this.intitule = intitule;
	}

	public String getSujet()
	{
		return sujet;
	}

	public void setSujet( String sujet )
	{
		this.sujet = sujet;
	}
}
