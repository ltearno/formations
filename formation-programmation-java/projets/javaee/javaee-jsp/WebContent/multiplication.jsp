<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
int debut = 2;
int fin = 15;
int increment = 3;

try{
	debut = Integer.parseInt(request.getParameter( "debut" ));
	fin = Integer.parseInt(request.getParameter( "fin" ));
	increment = Integer.parseInt(request.getParameter( "increment" ));
}catch(Exception e){
}
%>

<form method='post'>
	<label>Début : <input type='number' name='debut' value='<%= debut%>'/></label>
	<label>Fin : <input id='fin' type='number' name='fin'  value='<%= fin%>'/></label>
	<label>Incrément : <input type='number' name='increment' value='<%= increment%>'/></label>
	
	<button>ok</button>
</form>

<table border='1'>
<tr>
	<td></td>
	<% for (int column=debut; column <= fin; column += increment) { %>
		<th style='width:4em;height:4em;'><%= column %></th>
	<% } %>
</tr>
<% for (int row=debut; row <= fin; row += increment) { %>
	<tr>
		<th><%= row %></th>
		<% for (int column=debut; column <= fin; column += increment) { %>
			<td style='width:4em;height:4em;'><%= row*column %></td>
		<% } %>
	</tr>
<% } %>
</table>




</body>
</html>