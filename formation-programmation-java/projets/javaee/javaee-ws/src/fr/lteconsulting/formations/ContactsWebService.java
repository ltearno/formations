package fr.lteconsulting.formations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path( "contacts" )
public class ContactsWebService
{
	private static List<Contact> contacts = new ArrayList<>( Arrays.asList(
			new Contact( 1, "Toto", "067654321" ),
			new Contact( 2, "Tutu", "035627773" ),
			new Contact( 3, "Titi", "097766554" ) ) );

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Contact> getContacts()
	{
		return contacts;
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Contact findContact( @PathParam( "id" ) int id )
	{
		for( Contact contact : contacts )
			if( contact.getId() == id )
				return contact;

		return null;
	}

	@POST
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Contact ajouterContact( Contact contact )
	{
		contacts.add( contact );
		return contact;
	}
}
