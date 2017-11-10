package fr.lteconsulting.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.lteconsulting.model.ApplicationData;
import fr.lteconsulting.model.User;
import fr.lteconsulting.outil.ServletTools;

@WebServlet( "/welcome" )
public class WelcomeServlet extends HttpServlet
{
	@Resource( name = "BibliothequeDS" )
	private DataSource myDs;

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		try
		{
			Context ctx = new InitialContext();
			myDs = (DataSource) ctx.lookup("BibliothequeDS");
			
			Connection connexion = myDs.getConnection();
			Statement statement = connexion.createStatement();
			statement.execute( "select * from auteur" );

			ResultSet rs = statement.getResultSet();
			while( rs.next() )
			{
				int id = rs.getInt( "id" );
				String nom = rs.getString( "nom" );

				System.out.println( "id:" + id + " nom:" + nom );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		User user = ApplicationData.getConnectedUser( req );
		if( user == null )
			ServletTools.afficherPage( "Connexion utilisateur", "loginForm", req, resp );
		else
			ServletTools.afficherPage( "Acceuil", "welcomeUser", req, resp );
	}
}
