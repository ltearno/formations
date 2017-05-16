package fr.lteconsulting.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.BigDao;
import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Reponse;

public class ExportQuizzsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	BigDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		List<Quizz> quizzs = dao.getQuizzs();
		for( Quizz quizz : quizzs )
		{
			File file = new File( "C:\\Documents\\Repos\\formation-programmation-java\\_qcms\\" + quizz.getNom() + ".data" );
			FileOutputStream os = new FileOutputStream( file );

			PrintWriter out = new PrintWriter( file, "UTF-8" );
			try
			{
				int index = 1;

				List<Question> questions = dao.findQuestionsByQuizzId( quizz.getId() );
				for( Question question : questions )
				{
					out.println( index + ". " + question.getTexte() );

					for( Reponse reponse : question.getReponses() )
					{
						out.print( reponse.isValide() ? "+" : "-" );
						out.println( reponse.getTexte() );
					}

					out.println();

					index++;
				}
			}
			finally
			{
				out.close();
				os.close();
			}
		}
	}
}
