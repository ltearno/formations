package fr.lteconsulting.ejb;

import javax.ejb.Stateless;

@Stateless
public class GestionEmail
{
	public void envoyerEmail( String adresse )
	{
		System.out.println( "Envoi de l'email" );
	}
}
