package fr.lteconsulting.servlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.BigDao;
import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Reponse;

public class EditionQuizzServlet extends HttpServlet
{
	@EJB
	BigDao dao;

	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		Integer editedQuizzId = (Integer) request.getSession().getAttribute( "editedQuizzId" );
		if( editedQuizzId == null )
		{
			Rendu.pagePrincipale( "Choisissez un Quizz a créer ou éditer", "/WEB-INF/editQuizz.jsp", getServletContext(), request, response );
		}
		else
		{
			Rendu.pagePrincipale( "Ajouter une question au Quizz", "/WEB-INF/editQuestion.jsp", getServletContext(), request, response );
		}
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String quizzName = request.getParameter( "quizzName" );
		if( quizzName != null )
		{
			Quizz quizz = dao.findQuizzByName( quizzName );
			if( quizz == null )
			{
				quizz = new Quizz();
				quizz.setNom( quizzName );
				dao.addQuizz( quizz );
			}

			request.getSession().setAttribute( "editedQuizzId", quizz.getId() );

			response.sendRedirect( "editionQuizz" );
			return;
		}

		Integer editedQuizzId = (Integer) request.getSession().getAttribute( "editedQuizzId" );
		if( editedQuizzId != null )
		{
			Quizz quizz = dao.findQuizzById( editedQuizzId );

			String texteQuestion = request.getParameter( "question" );

			Question question = new Question();
			question.setQuizz( quizz );
			question.setTexte( texteQuestion );

			for( int i = 1; i <= 4; i++ )
			{
				String texteReponse = request.getParameter( "reponse" + i );
				if( texteReponse == null || texteReponse.isEmpty() )
					continue;

				boolean valideReponse = "yes".equals( request.getParameter( "valideReponse" + i ) );

				Reponse reponse = new Reponse();

				reponse.setTexte( texteReponse );
				reponse.setValide( valideReponse );

				question.addReponse( reponse );
			}

			dao.addQuestion( question );
		}

		response.sendRedirect( "editionQuizz" );
	}
}
