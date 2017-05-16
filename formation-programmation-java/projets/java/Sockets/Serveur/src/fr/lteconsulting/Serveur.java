package fr.lteconsulting;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur
{
	public static void main( String[] args )
	{
		try
		{
			System.out.println( "Ouverture port d'écoute" );
			ServerSocket socketServer = new ServerSocket( 9090 );

			System.out.println( "Attente connexion" );
			Socket communicationAvecClient = socketServer.accept();
			System.out.println( "Réception connexion" );

			InputStream is = communicationAvecClient.getInputStream();
			ObjectInputStream ois = new ObjectInputStream( is );

			OutputStream os = communicationAvecClient.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( os );

			Thread thread = new Thread( new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						while( true )
						{
							String reponse = ois.readUTF();
							System.out.println( "reçu : " + reponse );

							if( "!".equals( reponse ) )
								break;
						}
					}
					catch( Exception e )
					{
						e.printStackTrace();
					}
				}
			} );
			thread.start();

			while( true )
			{
				String message = Saisie.saisie( "message >" );
				oos.writeUTF( message );
				oos.flush();

				if( "!".equals( message ) )
					break;
			}

			communicationAvecClient.close();

			oos.close();
			os.close();
			ois.close();
			is.close();
			socketServer.close();

			System.out.println( "Fin" );
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}
}
