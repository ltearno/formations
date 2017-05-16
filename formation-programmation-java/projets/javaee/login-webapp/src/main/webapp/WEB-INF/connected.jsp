<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Bienvenue ${user.login}<br/>
	
	<a href="logout">se déconnecter</a><br/>
	
	<form action="logout" method="post">
		<button type="submit">se déconnecter</button>
	</form>
</body>
</html>