package fr.lteconsulting.ui;

import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.outils.Saisie;

public class OutilsSaisie
{
	public static Chanson saisirChanson()
	{
		String titre = Saisie.saisie( "Nom de la chanson (laisser vide pour terminer)" );
		if( titre.isEmpty() )
			return null;

		int duree = Saisie.saisieInt( "Durée de la chanson" );

		Chanson chanson = new Chanson( titre, duree );
		return chanson;
	}
}
