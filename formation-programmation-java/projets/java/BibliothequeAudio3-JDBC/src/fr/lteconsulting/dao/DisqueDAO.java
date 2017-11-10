package fr.lteconsulting.dao;

public class DisqueDAO
{
	/*private Connection connection;
	private ChansonDAO chansonDAO;

	public DisqueDAO( MySQLDatabaseConnection connection, ChansonDAO chansonDAO )
	{
		this.connection = connection.getConnection();
		this.chansonDAO = chansonDAO;
	}

	public Disque findById( String id )
	{
		try
		{
			String sql = "SELECT * FROM `disques` WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, id );
			ResultSet resultSet = statement.executeQuery();
			if( resultSet.next() )
				return createDisqueFromResultSet( resultSet );
			else
				return null;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public List<Disque> findAll()
	{
		try
		{
			List<Disque> disques = new ArrayList<>();

			String sql = "SELECT * FROM `disques`";
			PreparedStatement statement = connection.prepareStatement( sql );
			ResultSet resultSet = statement.executeQuery();
			while( resultSet.next() )
			{
				Disque disque = createDisqueFromResultSet( resultSet );
				disques.add( disque );
			}

			return disques;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public List<Disque> findByName( String search )
	{
		search = search.toLowerCase();

		try
		{
			List<Disque> disques = new ArrayList<>();

			String sql = "SELECT * FROM `disques` WHERE LOWER(`nom`) LIKE ?";
			PreparedStatement statement = connection.prepareStatement( sql );
			statement.setString( 1, "%" + search + "%" );
			ResultSet resultSet = statement.executeQuery();
			while( resultSet.next() )
			{
				Disque disque = createDisqueFromResultSet( resultSet );
				disques.add( disque );
			}

			return disques;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de réaliser l(es) opération(s)", e );
		}
	}

	public Disque add( Disque disque )
	{
		try
		{
			// génération d'un identifiant si nécessaire
			String id = disque.getCodeBarre();
			if( id == null )
				id = UUID.randomUUID().toString();

			String sqlQuery = "INSERT INTO disques (`id`, `nom`) VALUES (?, ?)";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setString( 1, id );
			statement.setString( 2, disque.getNom() );

			int nbEnregistrementInseres = statement.executeUpdate();
			if( nbEnregistrementInseres == 0 )
				throw new RuntimeException( "Aucun disque inséré" );

			// met à jour l'objet disque avec l'id généré
			// pour mettre l'appelant au courant de l'id généré
			disque.setCodeBarre( id );

			// insértion en base des chansons du disque
			for( Chanson chanson : disque.getChansons() )
			{
				chanson.setDisqueId( id );
				chansonDAO.add( chanson );
			}

			return disque;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible d'ajouter le disque", e );
		}
	}

	public void update( Disque disque )
	{
		if( disque.getCodeBarre() == null )
		{
			System.out.println( "ATTENTION, CE N'EST PAS UNE MAJ MAIS UN INSERT !" );
			add( disque );
			return;
		}

		try
		{
			String sqlQuery = "UPDATE disques SET `nom` = ? WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setString( 1, disque.getNom() );
			statement.setString( 2, disque.getCodeBarre() );

			statement.executeUpdate();

			// Mise à jour des chansons du disque : ceci se passe en deux étapes
			// c'est une version pas du tout optimisée, mais facile à comprendre !

			// ajouter en base les chansons qui n'ont pas d'id (c'est-à-dire quelles sont nouvelles)
			// mettre à jour les chansons qui ont un id
			for( Chanson chanson : disque.getChansons() )
			{
				if( chanson.getId() <= 0 )
					chansonDAO.add( chanson );
				else
					chansonDAO.update( chanson );
			}

			// supprimer les chansons qui sont dans la base pour ce disque mais qui ne sont pas dans l'objet disque
			for( Chanson chanson : chansonDAO.findByDisqueId( disque.getCodeBarre() ) )
			{
				if( !doesDisqueHasChanson( disque, chanson.getId() ) )
					chansonDAO.delete( chanson.getId() );
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de mettre à jour le disque", e );
		}
	}

	private boolean doesDisqueHasChanson( Disque disque, int chansonId )
	{
		for( Chanson chanson : disque.getChansons() )
		{
			if( chanson.getId() == chansonId )
				return true;
		}

		return false;
	}

	public void delete( String id )
	{
		try
		{
			// effacer toutes les chansons du disque puisqu'on efface le disque
			chansonDAO.deleteByDisqueId( id );

			String sqlQuery = "DELETE FROM disques WHERE id = ?";

			PreparedStatement statement = connection.prepareStatement( sqlQuery );
			statement.setString( 1, id );

			statement.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( "Impossible de retirer le disque", e );
		}
	}

	private Disque createDisqueFromResultSet( ResultSet resultSet ) throws SQLException
	{
		String id = resultSet.getString( "id" );
		String nom = resultSet.getString( "nom" );

		Disque disque = new Disque();
		disque.setCodeBarre( id );
		disque.setNom( nom );

		List<Chanson> chansons = chansonDAO.findByDisqueId( id );
		for( Chanson chanson : chansons )
			disque.addChanson( chanson );

		return disque;
	}*/
}
