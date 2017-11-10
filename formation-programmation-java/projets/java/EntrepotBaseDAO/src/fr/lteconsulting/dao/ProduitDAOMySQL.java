package fr.lteconsulting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.Produit;
import fr.lteconsulting.exception.DAOConfigurationException;
import fr.lteconsulting.exception.DAOException;

public class ProduitDAOMySQL implements ProduitDAO
{
	private final Connection databaseConnection;

	public ProduitDAOMySQL() throws DAOConfigurationException
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new DAOConfigurationException();
		}

		try
		{
			databaseConnection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/stock", "root", "" );
		}
		catch( SQLException e )
		{
			throw new DAOConfigurationException();
		}
	}

	@Override
	public List<Produit> getAll() throws DAOException
	{
		List<Produit> resultat = new ArrayList<>();

		Statement statement;
		try
		{
			statement = databaseConnection.createStatement();
			ResultSet rs = statement.executeQuery( "SELECT * from produits" );
			while( rs.next() )
			{
				int id = rs.getInt( "id" );
				String designation = rs.getString( "designation" );
				double prixUnitaire = rs.getDouble( "prixUnitaire" );

				Produit produit = new Produit();
				produit.setReference( id );
				produit.setDesignation( designation );
				produit.setPrixUnitaire( prixUnitaire );

				resultat.add( produit );
			}
		}
		catch( SQLException e )
		{
			throw new DAOException( "Impossible d'obtenir les produits de la base", e );
		}

		return resultat;
	}

	@Override
	public Produit getOne( int reference ) throws DAOException
	{
		Statement statement;
		try
		{
			statement = databaseConnection.createStatement();
			ResultSet rs = statement.executeQuery( "SELECT * from produits WHERE id=" + reference );
			while( rs.next() )
			{
				int id = rs.getInt( "id" );
				String designation = rs.getString( "designation" );
				double prixUnitaire = rs.getDouble( "prixUnitaire" );

				Produit produit = new Produit();
				produit.setReference( id );
				produit.setDesignation( designation );
				produit.setPrixUnitaire( prixUnitaire );

				return produit;
			}
		}
		catch( SQLException e )
		{
			throw new DAOException( "Impossible d'obtenir le produit depuis la base", e );
		}

		return null;
	}

	@Override
	public void addProduit( Produit produit ) throws DAOException
	{
		try
		{
			String sqlQuery = "INSERT INTO produits (`designation`, `prixUnitaire`) "
					+ "VALUES ('" + produit.getDesignation() + "', "
					+ produit.getPrixUnitaire() + ")";

			PreparedStatement statement = databaseConnection.prepareStatement( sqlQuery );
			int nbEnregistrementInseres = statement.executeUpdate();
			if( nbEnregistrementInseres == 0 )
				throw new DAOException( "Aucun enregistrement inséré" );

			ResultSet createdIds = statement.getGeneratedKeys();
			if( createdIds.next() )
				produit.setReference( createdIds.getInt( 1 ) );
			else
				throw new DAOException( "Aucun produit ajouté" );
		}
		catch( SQLException e )
		{
			throw new DAOException( "Impossible d'ajouter le produit en base", e );
		}
	}

	@Override
	public void updateProduit( Produit produit ) throws DAOException
	{
		Statement statement;
		try
		{
			String sqlQuery = "UPDATE produits "
					+ "SET 'designation' = '" + produit.getDesignation() + "', "
					+ "'prixUnitaire'=" + produit.getPrixUnitaire()
					+ " WHERE id=" + produit.getReference();

			statement = databaseConnection.createStatement();
			statement.executeUpdate( sqlQuery );
		}
		catch( SQLException e )
		{
			throw new DAOException( "Impossible de mettre à jour le produit en base", e );
		}
	}

	@Override
	public void deleteProduit( int reference ) throws DAOException
	{
		Statement statement;
		try
		{
			String sqlQuery = "DELETE FROM produits WHERE id=" + reference;

			statement = databaseConnection.createStatement();
			statement.executeUpdate( sqlQuery );
		}
		catch( SQLException e )
		{
			throw new DAOException( "Impossible d'effacer le produit de la base", e );
		}
	}
}
