package fr.lteconsulting.training.appengine.marvels;

import fr.lteconsulting.training.appengine.marvels.model.Character;
import fr.lteconsulting.training.appengine.marvels.model.CharacterList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin( origins = "*" )
@RestController
public class MarvelsController
{
	@Autowired
	private CharactersRepository repo;

	@RequestMapping( "/marvels" )
	public CharacterList getAll( @RequestParam( value = "offset" ) int offset )
	{
		CharacterList result = new CharacterList();

		result.total = repo.getAll().size();
		result.data = repo.getAll().stream()
				.skip( offset )
				.limit( 20 )
				.collect( Collectors.toList() );

		return result;
	}

	@RequestMapping( "/marvels/search" )
	public CharacterList search( @RequestParam( value = "name" ) String name, @RequestParam( value = "offset" ) int offset )
	{
		String searched = (name == null || "".equals( name )) ? null : name.toLowerCase();

		CharacterList result = new CharacterList();

		result.total = repo.getAll().size();
		result.data = repo.getAll().stream()
				.filter( character -> name == null || (character.name != null && character.name.toLowerCase().contains( name )) )
				.skip( offset )
				.limit( 20 )
				.collect( Collectors.toList() );

		return result;
	}
}