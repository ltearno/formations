package fr.lteconsulting.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pegdown.PegDownProcessor;

import fr.lteconsulting.dao.BigDao;
import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Reponse;
import fr.lteconsulting.model.ReponseUtilisateur;
import fr.lteconsulting.model.Utilisateur;

public class RepondreQuizzServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private BigDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String choosenQuizzId = request.getParameter( "chooseQuizz" );
		if( choosenQuizzId != null )
		{
			Integer quizzId = Integer.parseInt( choosenQuizzId );
			request.getSession().setAttribute( "answeredQuizzId", quizzId );
		}

		Integer answeredQuizzId = (Integer) request.getSession().getAttribute( "answeredQuizzId" );
		if( answeredQuizzId == null )
		{
			response.sendRedirect( "home" );
			return;
		}

		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute( "utilisateur" );
		PegDownProcessor markdown = new PegDownProcessor();

		List<Question> questions = dao.findNextQuestionsForUser( answeredQuizzId, utilisateur );
		if( questions.isEmpty() )
		{
			request.getSession().removeAttribute( "answeredQuizzId" );

			Rendu.pagePrincipale( "Quizz terminé !", "/WEB-INF/finishedQuizz.jsp", getServletContext(), request, response );
		}
		else
		{
			int nbRestant = questions.size();

			List<Question> randomized = new ArrayList<>();
			Random rnd = new Random();
			int nb = 1;
			while( nb-- > 0 && !questions.isEmpty() )
			{
				Question q = questions.remove( rnd.nextInt( questions.size() ) );

				q.setTexte( markdown.markdownToHtml( q.getTexte() ) );
				for( Reponse r : q.getReponses() )
					r.setTexte( markdown.markdownToHtml( r.getTexte() ) );

				randomized.add( q );
			}

			request.setAttribute( "nbRestant", nbRestant );
			request.setAttribute( "questions", randomized );

			Rendu.pagePrincipale( "Répondez au Quizz", "/WEB-INF/showQuizz.jsp", getServletContext(), request, response );
		}
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		@SuppressWarnings( { "unchecked" } )
		Map<String, Object> parameters = request.getParameterMap();

		for( Entry<String, Object> entry : parameters.entrySet() )
		{
			String name = entry.getKey();

			String magic = "reponse";
			if( name.startsWith( magic ) )
			{
				try
				{
					int reponseId = Integer.parseInt( name.substring( magic.length() ) );
					Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute( "utilisateur" );

					ReponseUtilisateur reponse = new ReponseUtilisateur();
					reponse.setUtilisateur( utilisateur );
					reponse.setReponse( dao.findReponseById( reponseId ) );

					dao.addReponseUtilisateur( reponse );
				}
				catch( Exception e )
				{
				}
			}
		}

		response.sendRedirect( "repondreQuizz" );
	}
}
