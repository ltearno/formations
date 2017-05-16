package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import fr.lteconsulting.Contact;

@Singleton
/**
 * Classe d'accès aux données Contacts
 */
public class ContactDao
{
	private int nextId = 55;
	private List<Contact> contacts = new ArrayList<>();

	public ContactDao()
	{
		contacts.add( new Contact( 1, "Roge", "Roger", "066666666" ) );
	}

	public List<Contact> getAll()
	{
		return contacts;
	}

	public Contact getById( int id )
	{
		for( Contact contact : contacts )
			if( contact.getId() == id )
				return contact;

		return null;
	}

	public void deleteById( int id )
	{
		Contact contact = getById( id );
		if( contact == null )
			return;

		contacts.remove( contact );
	}

	public Contact update( Contact contact )
	{
		deleteById( contact.getId() );
		contacts.add( contact );
		return contact;
	}

	public Contact create( Contact contact )
	{
		contact.setId( nextId++ );
		contacts.add( contact );

		return contact;
	}
}
