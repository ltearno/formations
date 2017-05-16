package fr.lteconsulting.training.struts.outils;

import fr.lteconsulting.training.struts.model.Marvel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Outils
{
	private static int nextMarvelId = 666;

	public static void ensureMarvelsInSession( Map<String, Object> session )
	{
		if( session.get( "marvels" ) != null )
			return;

		List<Marvel> marvels = new ArrayList<Marvel>();
		marvels.add( new Marvel( 1, "Toto", "Toto", "Toto" ) );
		marvels.add( new Marvel( 2, "Tato", "Toto", "Toto" ) );
		marvels.add( new Marvel( 3, "Tuto", "Toto", "Toto" ) );
		marvels.add( new Marvel( 4, "Tito", "Toto", "Toto" ) );

		session.put( "marvels", marvels );
	}

	public static Marvel findMarvelById( List<Marvel> marvels, int id )
	{
		for( Marvel marvel : marvels )
		{
			if( marvel.getId() == id )
				return marvel;
		}

		return null;
	}

	public static int getNextMarvelId()
	{
		return nextMarvelId++;
	}
}
