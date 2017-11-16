<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String title = (String) request.getAttribute("title");
    String pageToDisplay = (String) request.getAttribute("pageToDisplay");
%>
<html>
<head>
    <title>CATALOGUE (c) 2017 - <%= title %>
    </title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="Skeleton-2.0.4/css/normalize.css">
    <link rel="stylesheet" href="Skeleton-2.0.4/css/skeleton.css">
    <style>
        body {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            flex-flow: column nowrap;
            justify-content: center;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="<%= pageToDisplay %>"/>
    <div>
        <a href="produits">produits</a>
        -
        <a href="categories">catégories</a>
        -
        <a href="fabricants">fabricants</a>
        -
        <a href="logout">se déconnecter</a>
    </div>
</div>
</body>
</html>
