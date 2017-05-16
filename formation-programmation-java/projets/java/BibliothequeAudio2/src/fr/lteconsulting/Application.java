package fr.lteconsulting;

import fr.lteconsulting.modele.Bibliotheque;
import fr.lteconsulting.modele.Chanson;
import fr.lteconsulting.modele.Disque;

public class Application
{
	public static void main( String[] args )
	{
		Bibliotheque b = new Bibliotheque();

		Disque d = new Disque( "La Lune" );
		d.addChanson( new Chanson( "Titre", 34 ) );
		d.addChanson( new Chanson( "Titre", 34 ) );
		b.ajouterDisque( d );

		d = new Disque( "Le soleil" );
		d.addChanson( new Chanson( "Titre", 34 ) );
		d.addChanson( new Chanson( "Blah", 23 ) );
		d.addChanson( new Chanson( "Titre", 34 ) );
		d.addChanson( new Chanson( "Titre", 34 ) );
		d.addChanson( new Chanson( "Titre", 34 ) );
		b.ajouterDisque( d );
		
		InferfaceUtilisateur ui = new InferfaceUtilisateur( b );

		ui.execute();
	}
}
