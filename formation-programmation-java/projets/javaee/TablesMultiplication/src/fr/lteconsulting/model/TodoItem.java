package fr.lteconsulting.model;

import java.util.Date;

public class TodoItem
{
	private String text;
	private Date creationDate;
	private boolean done;

	public TodoItem( String text, Date creationDate, boolean done )
	{
		this.text = text;
		this.creationDate = creationDate;
		this.done = done;
	}

	public String getText()
	{
		return text;
	}

	public void setText( String text )
	{
		this.text = text;
	}

	public Date getCreationDate()
	{
		return creationDate;
	}

	public void setCreationDate( Date creationDate )
	{
		this.creationDate = creationDate;
	}

	public boolean isDone()
	{
		return done;
	}

	public void setDone( boolean done )
	{
		this.done = done;
	}
}
