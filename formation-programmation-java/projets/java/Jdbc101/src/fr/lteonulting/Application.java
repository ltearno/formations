package fr.lteonulting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application
{
	public static void main( String[] args )
	{
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/stock", "root", "" );

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery( "SELECT id, designation, prixUnitaire from produits" );
			while( rs.next() )
			{
				int id = rs.getInt( "id" );
				String designation = rs.getString( "designation" );
				double prixUnitaire = rs.getDouble( "prixUnitaire" );

				System.out.println( "id:" + id + ", designation:" + designation + ", prix:" + prixUnitaire );
			}

		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "ERREUR CHARGEMENT JDBC" );
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
	}
}
