package fr.lteconsulting.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pegdown.PegDownProcessor;

import fr.lteconsulting.dao.BigDao;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Utilisateur;

public class ResultatsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private BigDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		List<Utilisateur> utilisateurs = dao.getUtilisateurs();

		PegDownProcessor markdown = new PegDownProcessor();

		StringBuilder sb = new StringBuilder();

		sb.append( "nom;email;score;allgood;onebad;onegood;bad;nbquestions\n" );

		for( Quizz quizz : dao.getQuizzs() )
		{
			// sb.append( "##" + quizz.getNom() + "\n" );

			for( Utilisateur utilisateur : utilisateurs )
			{
				// sb.append( "###" + utilisateur.getNomComplet() + "\n" );

				String results = dao.processResultats( quizz.getId(), utilisateur.getId() );
				sb.append( results );
			}
		}

		response.setContentType( "text/csv" );
		response.setCharacterEncoding( "UTF-8" );

//		response.getWriter().print( markdown.markdownToHtml( sb.toString() ) );
		response.getWriter().print( sb.toString() );
	}
}
