package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Joueur
{
	private List<Carte> main = new ArrayList<>();

	public void prendCarte( Carte carte )
	{
		main.add( carte );
	}

	public Carte donneCarte()
	{
		if( main.isEmpty() )
			return null;

		return main.remove( 0 );
	}

	public int getNbCartes()
	{
		return main.size();
	}
}
