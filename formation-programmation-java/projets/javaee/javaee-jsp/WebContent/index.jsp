<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session utilisateur</title>
</head>
<body>

Nous sommes le
<b><%
Date date = new Date();
out.print( date );
%></b>

<br/><br/><br/>

Nous sommes le <b><%= new Date() %></b>



</body>
</html>





