package fr.lteconsulting;

public class Personne
{
	String nom;
	int numeroSecu;

	@Override
	public String toString()
	{
		return "Personne [nom=" + nom + ", numeroSecu=" + numeroSecu + "]";
	}
	
	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroSecu;
		return result;
	}



	@Override
	public boolean equals( Object obj )
	{
		if( this == obj )
			return true;
		if( obj == null )
			return false;
		if( !(obj instanceof Personne) )
			return false;
		Personne other = (Personne) obj;
		if( numeroSecu != other.numeroSecu )
			return false;
		return true;
	}



	public Personne( String nom, int numeroSecu )
	{
		this.nom = nom;
		this.numeroSecu = numeroSecu;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public int getNumeroSecu()
	{
		return numeroSecu;
	}

	public void setNumeroSecu( int numeroSecu )
	{
		this.numeroSecu = numeroSecu;
	}
}