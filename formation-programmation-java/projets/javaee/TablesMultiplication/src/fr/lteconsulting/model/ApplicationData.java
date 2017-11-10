package fr.lteconsulting.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ApplicationData
{
	public static List<TodoItem> getTodoList( HttpServletRequest request )
	{
		User connectedUser = getConnectedUser( request );
		if( connectedUser == null )
			return null;

		return connectedUser.getTodoList();
	}

	public static void addTodoListItem( String text, HttpServletRequest request )
	{
		List<TodoItem> todoList = getTodoList( request );

		if( todoList != null )
			todoList.add( new TodoItem( text, new Date(), false ) );
	}

	public static void removeTodoListItem( int index, HttpServletRequest request )
	{
		List<TodoItem> todoList = getTodoList( request );

		if( todoList != null && index >= 0 && index < todoList.size() )
			todoList.remove( index );
	}

	public static void toggleTodoListItemDoneState( int index, HttpServletRequest request )
	{
		List<TodoItem> todoList = getTodoList( request );

		if( todoList != null && index >= 0 && index < todoList.size() )
			todoList.get( index ).setDone( !todoList.get( index ).isDone() );
	}

	/**
	 * Récupère l'utilisateur en session, ou null si aucun
	 * 
	 * @param request
	 * @return
	 */
	public static User getConnectedUser( HttpServletRequest request )
	{
		return (User) request.getSession().getAttribute( "connectedUser" );
	}

	/**
	 * Enregistre l'utilisateur en session
	 * 
	 * @param request
	 * @param user
	 */
	public static void setConnectedUser( HttpServletRequest request, User user )
	{
		request.getSession().setAttribute( "connectedUser", user );
	}

	/**
	 * Récupère la liste des utilisateurs à partir du contexte applicatif
	 * 
	 * @param servletContext
	 * @return
	 */
	public static List<User> getUserDatabase( ServletContext servletContext )
	{
		List<User> userDatabase = (List<User>) servletContext.getAttribute( "userDatabase" );

		if( userDatabase == null )
		{
			userDatabase = new ArrayList<>();
			servletContext.setAttribute( "userDatabase", userDatabase );
		}

		return userDatabase;
	}

	/**
	 * Récupère la liste des utilisateurs à partir du traitement d'une requete Http
	 * 
	 * @param servletContext
	 * @return
	 */
	public static List<User> getUserDatabase( HttpServletRequest request )
	{
		return getUserDatabase( request.getServletContext() );
	}
}
