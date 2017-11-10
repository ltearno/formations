package fr.lteconsulting;

import java.util.Date;

public class Utilisateur
{
	private String firstName;
	private String lastName;
	private Date lastConnectionDate;

	public Utilisateur( String firstName, String lastName, Date lastConnectionDate )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastConnectionDate = lastConnectionDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public Date getLastConnectionDate()
	{
		return lastConnectionDate;
	}

	public String getFullName()
	{
		return firstName + " " + lastName;
	}
}
