package fr.lteconsulting;

public class Personne
{
	private String nom;
	private int secu;

	public Personne( String nom, int secu )
	{
		this.nom = nom;
		this.secu = secu;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + secu;
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if( this == obj )
			return true;
		if( obj == null )
			return false;
		if( getClass() != obj.getClass() )
			return false;
		Personne other = (Personne) obj;
		if( nom == null )
		{
			if( other.nom != null )
				return false;
		}
		else if( !nom.equals( other.nom ) )
			return false;
		if( secu != other.secu )
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Personne [secu=" + secu + ", nom=" + nom + "]";
	}
}
