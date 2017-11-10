package fr.lteconsulting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User
{
	private String pseudo;
	private String password;
	private String firstName;
	private String lastName;
	private List<TodoItem> todoList;

	public User( String pseudo, String password, String firstName, String lastName )
	{
		this.pseudo = pseudo;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

		todoList = new ArrayList<>();
		todoList.add( new TodoItem( "(prérempli) 😁😂😃😍🚲", new Date(), false ) );
		todoList.add( new TodoItem( "(prérempli) لوحة المفاتيح العربية", new Date(), false ) );
		todoList.add( new TodoItem( "(prérempli) 加强两地农业等领域合作", new Date(), false ) );
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public void setPseudo( String pseudo )
	{
		this.pseudo = pseudo;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public List<TodoItem> getTodoList()
	{
		return todoList;
	}

	public void setTodoList( List<TodoItem> todoList )
	{
		this.todoList = todoList;
	}
}
