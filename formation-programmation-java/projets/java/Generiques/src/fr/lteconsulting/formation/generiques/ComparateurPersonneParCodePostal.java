package fr.lteconsulting.formation.generiques;

import java.util.Comparator;

public class ComparateurPersonneParCodePostal implements Comparator<Personne>
{
	@Override
	public int compare( Personne o1, Personne o2 )
	{
		if( o1.getCodePostal() < o2.getCodePostal() )
			return -1;
		else if( o1.getCodePostal() > o2.getCodePostal() )
			return 1;
		else
			return 0;
	}
}
