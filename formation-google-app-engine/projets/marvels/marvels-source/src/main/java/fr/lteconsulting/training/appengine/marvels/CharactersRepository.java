package fr.lteconsulting.training.appengine.marvels;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.lteconsulting.training.appengine.marvels.model.Character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class CharactersRepository
{
	private List<Character> data;

	public void load()
	{
		StringBuilder sb = new StringBuilder();
		try( FileReader reader = new FileReader( "marvels.json" ) )
		{
			try( BufferedReader br = new BufferedReader( reader ) )
			{
				while( true )
				{
					String line = br.readLine();
					if( line == null )
						break;

					sb.append( line );
				}
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			return;
		}

		String content = sb.toString();

		Type listType = new TypeToken<List<Character>>()
		{
		}.getType();

		data = new Gson().fromJson( content, listType );
	}

	public List<Character> getAll()
	{
		return data;
	}
}
