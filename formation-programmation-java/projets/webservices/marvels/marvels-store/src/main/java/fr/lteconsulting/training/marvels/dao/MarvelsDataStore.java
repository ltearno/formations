package fr.lteconsulting.training.marvels.dao;

import fr.lteconsulting.training.marvels.Marvel;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class MarvelsDataStore
{
	private List<Marvel> marvels;

	@PostConstruct
	void onInit()
	{
		marvels = new ArrayList<>();
		marvels.add( new Marvel( "sajahgkhgkjhg", "Bruce" ) );
		marvels.add( new Marvel( "lkjhsloioa", "Peter" ) );
		marvels.add( new Marvel( "iaud-h", "Sam" ) );
	}

	public List<Marvel> getAll()
	{
		return marvels;
	}

	public Marvel findById( String id )
	{
		if( id == null )
			return null;

		return marvels
				.stream()
				.filter( marvel -> id.equals( marvel.getId() ) )
				.findFirst()
				.orElse( null );
	}

	public Marvel create( Marvel marvel )
	{
		marvel.setId( UUID.randomUUID().toString() );

		marvels.add( marvel );

		return marvel;
	}

	public Marvel update( Marvel model )
	{
		Marvel existing = findById( model.getId() );
		if( existing == null )
			return null;

		existing.setName( model.getName() );

		return existing;
	}

	public boolean remove( String id )
	{
		Marvel existing = findById( id );

		return marvels.remove( existing );
	}
}
