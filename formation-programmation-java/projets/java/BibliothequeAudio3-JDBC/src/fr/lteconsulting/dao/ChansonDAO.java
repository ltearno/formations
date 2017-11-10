package fr.lteconsulting.dao;

public class ChansonDAO
{
	/*private Connection connection;

	public ChansonDAO( MySQLDatabaseConnection connection )
	{
		this.connection = connection.getConnection();
	}

	public Chanson findById( String id )
	{
		try
		{
			String sql = "SELECT * FROM `chansons` WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, id );
			ResultSet resultSet = statement.executeQuery();
			if( resultSet.next() )
				return createChansonFromResultSet( resultSet );
			else
				return null;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public List<Chanson> findAll()
	{
		try
		{
			List<Chanson> chansons = new ArrayList<>();

			String sql = "SELECT * FROM `chansons`";
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();
			while( resultSet.next() )
				chansons.add( createChansonFromResultSet( resultSet ) );

			return chansons;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public List<Chanson> findByDisqueId( String disqueId )
	{
		try
		{
			List<Chanson> chansons = new ArrayList<>();

			String sql = "SELECT * FROM `chansons` WHERE `disque_id` = ?";
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, disqueId );
			ResultSet resultSet = statement.executeQuery();
			while( resultSet.next() )
				chansons.add( createChansonFromResultSet( resultSet ) );

			return chansons;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public Chanson add( Chanson chanson )
	{
		if( chanson.getDisqueId() == null )
			throw new RuntimeException( "Impossible d'ajouter une chanson sans connaître son disque !" );

		try
		{
			String sqlQuery = "INSERT INTO chansons (`disque_id`, `nom`, `duree`) VALUES (?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement( sqlQuery, Statement.RETURN_GENERATED_KEYS );
			statement.setString( 1, chanson.getDisqueId() );
			statement.setString( 2, chanson.getNom() );
			statement.setInt( 3, chanson.getDureeEnSecondes() );

			int nbEnregistrementInseres = statement.executeUpdate();
			if( nbEnregistrementInseres == 0 )
				throw new RuntimeException( "Aucune chanson insérée" );

			ResultSet createdIds = statement.getGeneratedKeys();
			if( createdIds.next() )
			{
				chanson.setId( createdIds.getInt( 1 ) );
				return chanson;
			}

			throw new RuntimeException( "Aucun chanson ajoutée" );
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible d'ajouter la chanson", e );
		}
	}

	public void update( Chanson chanson )
	{
		if( chanson.getDisqueId() == null )
			throw new RuntimeException( "Impossible de modifier une chanson sans connaître son disque !" );

		try
		{
			String sqlQuery = "UPDATE chansons SET `disque_id` = ?, `nom` = ?, `duree` = ? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setString( 1, chanson.getDisqueId() );
			statement.setString( 2, chanson.getNom() );
			statement.setInt( 3, chanson.getDureeEnSecondes() );
			statement.setInt( 4, chanson.getId() );

			statement.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de mettre à jour la chanson", e );
		}
	}

	public void delete( int id )
	{
		try
		{
			String sqlQuery = "DELETE FROM chansons WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setInt( 1, id );

			statement.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de retirer la chanson", e );
		}
	}

	public void deleteByDisqueId( String disqueId )
	{
		try
		{
			String sqlQuery = "DELETE FROM chansons WHERE disque_id = ?";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setString( 1, disqueId );

			statement.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de retirer la chanson", e );
		}
	}

	private Chanson createChansonFromResultSet( ResultSet resultSet ) throws SQLException
	{
		int id = resultSet.getInt( "id" );
		String disqueId = resultSet.getString( "disque_id" );
		String nom = resultSet.getString( "nom" );
		int duree = resultSet.getInt( "duree" );

		Chanson chanson = new Chanson();

		chanson.setId( id );
		chanson.setNom( nom );
		chanson.setDureeEnSecondes( duree );
		chanson.setDisqueId( disqueId );

		return chanson;
	}*/
}
