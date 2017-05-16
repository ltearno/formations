<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="true" %>
<%@ page import="fr.lteconsulting.training.appengine.RuntimeInfo" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.users.User" %>
<html>
<head>
    <title>Marvels Scanner</title>

    <script src="jquery-3.2.0.min.js"></script>
    <script src="components.js"></script>
    <link rel="stylesheet" href="main.css">

    <script>
        class DataProvider {
            getCharacters(offset) {
                return request('http://ks387039.kimsufi.com:80/marvels?offset=' + offset);
            }

            getCharacterComments(id) {
                return request('/api/marvel-metadata/comment/' + id);
            }

            addComment(id, content) {
                return request('/api/marvel-metadata/comment/' + id, 'post', {content: content});
            }

            removeComment(commentKey) {
                return request('/api/marvel-metadata/comment/' + commentKey, 'delete');
            }

            searchCharacters(name) {
                return request(`http://ks387039.kimsufi.com:80/marvels/search?offset=0&name=${name}`);
            }
        }

        window.addEventListener('load', () => {
            let injector = createInjector();
            injector.register('dataService', new DataProvider());

            let application = document.querySelector("#application");
            let applicationComponent = new ApplicationComponent(injector);
            application.appendChild(applicationComponent.rootElement());

            applicationComponent.start();
        });
    </script>
</head>
<body>
<header>
    <h1>Marvels Scanner</h1>

    <div>
        You are <%= request.getAttribute( "pseudo" )  %> - <a href="/registration">profile</a> - <a href="<%=request.getAttribute( "logoutUrl") %>">logout</a>
    </div>
</header>

<div id="application"></div>

<footer>
    Infos: <%= request.getAttribute( "info" )  %>
</footer>

</body>
</html>
