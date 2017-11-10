<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fr.lteconsulting.model.TodoItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	pageContext.setAttribute( "dateFormatter", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss" ) );
%>

<h1>Todo liste</h1>

<ul>
	<c:forEach var='item' varStatus='loop' items='${todoList}'>
		<li>
			<span class='item-date'>${dateFormatter.format(item.creationDate)} </span>
			 
			<span class='item-text ${item.isDone() ? "item-done" : "item-not-done"}'>${item.text}</span>
			 
			<form method='post' action='toggleTodoListItemDoneState'>
				<input type='hidden' name='itemNo' value='${loop.index}' />
				<button role='submit' class='button button-clear'>${item.isDone() ? "👎" : "👌"}</button>
			</form>
			
			<form method='post' action='deleteTodoListItem'>
				<input type='hidden' name='itemNo' value='${loop.index}' />
				<button role='submit' class='button button-clear'>❌</button>
			</form>
		</li>
	</c:forEach>
</ul>

<form method='post' action='addTodoListItem'>
	<input type='text' name='item' autofocus placeholder="Saisissez l'élément à ajouter" />
	<button role='submit'>Ajouter</button>
</form>