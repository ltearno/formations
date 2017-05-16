package fr.lteconsulting.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.dao.BigDao;
import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Reponse;

public class ImportQuizzServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@EJB
	private BigDao dao;

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		importQuizz( "java" );
		importQuizz( "javaee-jsp" );
		importQuizz( "html" );
	}

	public void importQuizz( String quizzName ) throws FileNotFoundException, UnsupportedEncodingException, IOException
	{
		String directory = "C:\\Documents\\Repos\\formation-programmation-java\\_qcms\\";
		File file = new File( directory + quizzName + ".txt" );
		FileInputStream fis = new FileInputStream( file );
		InputStreamReader isr = new InputStreamReader( fis, "UTF-8" );
		BufferedReader r = new BufferedReader( isr );

		Quizz quizz = new Quizz();
		quizz.setNom( quizzName );
		dao.addQuizz( quizz );

		String line = null;
		StringBuilder buffer = new StringBuilder();
		Question currentQuestion = null;
		while( (line = r.readLine()) != null )
		{
			if( isReponseLine( line ) )
			{
				Reponse reponse = new Reponse();
				reponse.setQuestion( currentQuestion );
				reponse.setTexte( line.substring( 1 ) );
				reponse.setValide( line.charAt( 0 ) == '+' );

				currentQuestion.addReponse( reponse );
			}
			else
			{
				if( isQuestionLine( line ) )
				{
					if( currentQuestion != null )
					{
						currentQuestion.setTexte( buffer.toString().trim() );
						dao.addQuestion( currentQuestion );
					}

					currentQuestion = new Question();
					currentQuestion.setQuizz( quizz );

					buffer = new StringBuilder();

					buffer.append( line.substring( line.indexOf( '.' ) + 1 ) + "\r\n" );
				}
				else
				{
					if( currentQuestion != null && (currentQuestion.getReponses() == null || currentQuestion.getReponses().isEmpty()) )
						buffer.append( line + "\r\n" );
				}
			}
		}

		r.close();
	}

	private static boolean isReponseLine( String line )
	{
		return line != null && (line.startsWith( "-" ) || line.startsWith( "+" ));
	}

	private static boolean isQuestionLine( String line )
	{
		int dotIndex = line.indexOf( "." );
		if( dotIndex < 1 )
			return false;

		try
		{
			Integer.parseInt( line.substring( 0, dotIndex ) );
			return true;
		}
		catch( NumberFormatException e )
		{
			return false;
		}
	}
}
