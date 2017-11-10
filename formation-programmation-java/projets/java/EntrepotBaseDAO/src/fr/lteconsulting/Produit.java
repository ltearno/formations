package fr.lteconsulting;

public class Produit
{
	private int reference;
	private String designation;
	private double prixUnitaire;

	public Produit()
	{
	}

	public void afficher()
	{
		System.out.println( "Je suis le produit " + reference + " => " + designation );
	}

	public int getReference()
	{
		return reference;
	}

	public void setReference( int reference )
	{
		this.reference = reference;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation( String designation )
	{
		this.designation = designation;
	}

	public double getPrixUnitaire()
	{
		return prixUnitaire;
	}

	public void setPrixUnitaire( double prixUnitaire )
	{
		this.prixUnitaire = prixUnitaire;
	}
}
