package fr.lteconsulting.formations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path( "contacts" )
public class ContactsWebService
{
	private static List<Contact> contacts = new ArrayList<>( Arrays.asList(
			new Contact( 1, "toto", "titi" ),
			new Contact( 2, "tutu", "oyiuy" ),
			new Contact( 3, "lkjh", "POFIPOI" ) ) );

	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Contact> getAll()
	{
		return contacts;
	}

	@GET
	@Path( "{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Contact getOne( @PathParam( "id" ) int id )
	{
		return contacts.stream().filter( contact -> contact.getId() == id ).findFirst().orElse( null );
	}

	@PUT
	@Consumes( MediaType.APPLICATION_JSON )
	@Produces( MediaType.APPLICATION_JSON )
	public Contact create( Contact contact )
	{
		contacts.add( contact );
		return contact;
	}

	@Path( "search" )
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public List<Contact> search( @QueryParam( "name" ) String name )
	{
		return contacts.stream().filter( contact -> contact.getNom().contains( name ) ).collect( Collectors.toList() );
	}
}