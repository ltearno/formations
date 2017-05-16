package fr.lteconsulting.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class App
{
	public static void main( String[] args )
	{
		try
		{
			System.out.println( "Enregistrement du driver..." );
			Class.forName( "com.mysql.jdbc.Driver" );

			System.out.println( "Ouverture de la connexion à la base de données" );
			Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/exercice_sql", "root", null );

			conn.setAutoCommit( false );
			
			// Ajout de 10 cartes à la BDD
			for( int i = 0; i < 10; i++ )
				ajouterCarte( "lkjhlkj" + i, i + "jhkjh", conn );

			// Ceci a été remplacé avec la méthode getCartes()
			// Statement statement = conn.createStatement();
			// ResultSet rs = statement.executeQuery( "SELECT id, nom, couleur from cartes" );
			// while( rs.next() )
			// {
			// String id = rs.getString( "id" );
			// String nom = rs.getString( "nom" );
			// String couleur = rs.getString( "couleur" );
			//
			// System.out.printf( "%s %s %s\n", id, nom, couleur );
			// }

			// MAJ carte avec id=1
			updateCarte( 1, "Toto " + Math.random(), "COUL " + Math.random(), conn );

			// On demande la liste des carte pour en modifier une
			List<Carte> cartes = getCartes( conn );
			if( cartes.size() > 2 )
			{
				Carte carte = cartes.get( 1 );

				// on modifie la carte
				carte.setCouleur( "EHEH" + Math.random() );
				carte.setNom( "OHOH" + Math.random() );

				// et on enregistre en base de données
				updateCarte( carte, conn );
			}

			// obtention de la liste des cartes
			cartes = getCartes( conn );
			System.out.println( "il y a " + cartes.size() + " cartes en BDD" );
			for( Carte carte : cartes )
			{
				System.out.println( "- " + carte );
			}
			
			conn.commit();

			System.out.println( "Fermeture de la connexion à la base de données" );
			conn.close();
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "Ne parvient pas à trouver le driver JDBC !!" );
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
	}

	static List<Carte> getCartes( Connection conn ) throws SQLException
	{
		List<Carte> result = new ArrayList<>();

		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery( "SELECT id, nom, couleur from cartes" );
		while( rs.next() )
		{
			Long id = rs.getLong( "id" );
			String nom = rs.getString( "nom" );
			String couleur = rs.getString( "couleur" );

			Carte carte = new Carte();
			carte.setId( (int) (long) id );
			carte.setNom( nom );
			carte.setCouleur( couleur );

			result.add( carte );
		}

		return result;
	}

	static void ajouterCarte( String nom, String couleur, Connection conn ) throws SQLException
	{
		System.out.println( "AJOUT CARTE " + nom + " " + couleur );

		String sql = String.format( "insert into cartes (`nom`, `couleur`) values ('%s', '%s')",
				nom,
				couleur );

		Statement statement = conn.createStatement();
		statement.execute( sql );
	}

	static void updateCarte( int id, String nom, String couleur, Connection conn ) throws SQLException
	{
		String sql = String.format( "update `cartes` set nom='%s', couleur='%s' where id=%d", nom, couleur, id );
		conn.createStatement().executeUpdate( sql );
	}

	static void updateCarte( Carte carte, Connection conn ) throws SQLException
	{
		System.out.println( "MAJ CARTE : " + carte );
		String sql = String.format( "update `cartes` set nom='%s', couleur='%s' where id=%d", carte.getNom(), carte.getCouleur(), carte.getId() );
		conn.createStatement().executeUpdate( sql );
	}
}
