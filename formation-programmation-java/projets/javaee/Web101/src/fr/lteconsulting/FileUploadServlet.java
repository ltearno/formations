package fr.lteconsulting;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet( "/fileUpload.html" )
@MultipartConfig
public class FileUploadServlet extends HttpServlet
{
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		req.getRequestDispatcher( "/WEB-INF/uploadForm.jsp" ).forward( req, resp );
	}

	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
	{
		Part part = req.getPart( "fichier" );
		InputStream is = part.getInputStream();

		while( true )
		{
			byte[] buffer = new byte[16];

			int nbReadden = is.read( buffer );
			if( nbReadden <= 0 )
				break;

			for( int i = 0; i < nbReadden; i++ )
			{
				System.out.print( Integer.toString( buffer[i] & 0xff, 16 ) );
			}
			System.out.println();
		}
	}
}
