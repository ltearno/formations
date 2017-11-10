package fr.lteconsulting;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurWeb
{
	public static void main( String[] args ) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket( 9090 );

		System.out.println( "Le serveur Web est pret" );

		Socket socket = serverSocket.accept();

		System.out.println( "CONNEXION RECUE ET ACCEPTEE" );

		InputStream is = socket.getInputStream();

		while( true )
		{
			int data = is.read();
			if( data == -1 )
				break;

			// System.out.print( Integer.toHexString( (data & 0xff) ) + " " );
			System.out.print( (char) data );
		}
	}
}
