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
String nom = request.getParameter( "nom" );
if(nom!=null &&!nom.isEmpty(  ))
	session.setAttribute( "username", nom );
%>

<%
String userName = (String) session.getAttribute( "username" );
if(userName!=null && !userName.isEmpty(  )){
	%>Bonjour <%= userName %><%
}
else {
	%>
	<form method='post'>
		<input type='text' name='nom'/>
		<button>ok</button>
	</form>
	<%
}
%>

</body>
</html>








