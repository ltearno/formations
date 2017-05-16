package fr.lteconsulting.gravite;

import java.util.ArrayList;
import java.util.List;

public class Gravite
{
	public static void main( String[] args )
	{
		GraviteDisplay d = new GraviteDisplay();

		List<Particule> particules = new ArrayList<>();
		particules.add( new Particule( 0.2f, 0.2f, 0.3f ) );
		particules.add( new Particule( 0.8f, 0.2f, 0.3f ) );
		particules.add( new Particule( 0.2f, 0.8f, 0.3f ) );

		d.setParticules( particules );

		d.display();
	}
}
