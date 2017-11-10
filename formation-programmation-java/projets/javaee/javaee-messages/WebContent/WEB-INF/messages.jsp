<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<String> messages = (List<String>) request.getAttribute( "messages" );
%>

<ul>
<% for(String message: messages){
	%><li><%=message%></li><%
} %>
</ul>

<%@include file='formulaire-message.jsp' %>

</body>
</html>