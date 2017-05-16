package fr.lteconsulting.training.appengine.marvels;

import com.google.gson.Gson;
import fr.lteconsulting.training.appengine.marvels.model.Character;
import fr.lteconsulting.training.appengine.marvels.model.CharacterDataWrapper;
import fr.lteconsulting.training.appengine.marvels.tools.MD5Tools;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarvelGrab
{
	public static void main( String[] args )
	{
		String timeStamp = "1";
		String publicKey = "2c4c69c4f2c2fd59cdbe9dc9429d254e";
		String privateKey = "952fb13aeeb2ea14103811d46d3f48461c161918";

		String hash = MD5Tools.md5( timeStamp + privateKey + publicKey );

		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( "https://gateway.marvel.com:443/v1/public" );
		MarvelCharactersWS service = target.proxy( MarvelCharactersWS.class );

		List<Character> characters = new ArrayList<>();

		int offset = 0;
		while( true )
		{
			System.out.println( "offset: " + offset );
			CharacterDataWrapper marvels = service.getCharacters( timeStamp, publicKey, hash, offset );
			if( marvels == null || marvels.data == null || marvels.data.results == null )
				break;

			offset += marvels.data.results.size();
			if( offset >= marvels.data.total )
				break;

			characters.addAll( marvels.data.results );
		}

		System.out.println( "finished" );

		Gson gson = new Gson();
		String content = gson.toJson( characters );

		System.out.println( content );

		try
		{
			FileWriter writer = new FileWriter( "marvels.json" );
			writer.write( content );
			writer.close();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		System.out.println( "done" );
	}
}
