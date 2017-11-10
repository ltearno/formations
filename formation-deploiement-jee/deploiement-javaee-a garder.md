% Déploiement Java EE
%
% UTI Blagnac - 2016 - LTE Consulting

### Arnaud Tournier

<aside class="notes">
{data-background="gwt-con.png"}
</aside>

Passionnate developper, trainer and architect at **LTE Consulting**.

Speaker at **Devoxx**, **GWT.create**, **Paris**/**Toulouse JUG**, etc...

Email : ltearno@gmail.com

Twitter : @ltearno

Website : www.lteconsulting.fr

Full stack (x86_64 to JavaScript)

##

Docs JBoss

https://docs.jboss.org/jbossweb/3.0.x/deployer-howto.html

###

Que'est-ce que le déploiement ? C'est installer (ou mettre à jour) une application dans un serveur d'application.

Extension du déploiement : gestion de bout en bout de l'exploitation du code depuis le moment où il est produit par le développeur (continuous delivery).

## Déploiements chez JBoss

- statique : l'application est déployée dans le JBoss avant son démarrage
- dynamique : pendant le fonctionnement de JBoss il est possible de déployer ou redéployer une application. Plusieurs façons de faire (JBoss Web Manager : déploiement basé sur technos web, Client Deployer - TCD : cli qui utilise Web Manager, copie directe).

### Faire un déploiement statique

### Faire un déploiement avec JBoss Web Manager

### Faire un déploiement avec le Client Deployer

installer jbossweb-2.1.x-deployer

[https://docs.jboss.org/jbossweb/3.0.x/deployer-howto.html#Deploying using the Client Deployer Package](https://docs.jboss.org/jbossweb/3.0.x/deployer-howto.html#Deploying using the Client Deployer Package)

- installation du Client Deployer

**Tuto pour installer TCD !**

### Les contextes

The locations for Context Descriptors are;

$CATALINA_HOME/conf/[enginename]/[hostname]/context.xml
$CATALINA_HOME/webapps/[webappname]/META-INF/context.xml

Servent à instruire JBoss sur la façon de déployer l'application. Des valeurs par défauts sont implémentées, ainsi pour des applications très simples le fichier de contexte n'est pas forcément nécessaire.

NB : Le fichier de contexte est aussi utilisé par les outils de déploiement de JBoss

## Déploiement statique

The location you deploy web applications to for this type of deployment is called the appBase which is specified per Host. You either copy a so-called exploded web application, i.e non-compressed, to this location, or a compressed web application resource .WAR file.

Enchainement :

- JBoss déploie d'abord les Descripteurs de Contexte,
- Puis les applications explosées contenues dans *appBase*,
- Puis les fichiers .WAR compressés.

### Déploiement sur JBoss actif

Si la configuration `autoDeploy` se trouve à `true`, JBoss surveille le répertoire des déploiement et redéploie automatiquement quand :

- un nouveau WAR est déposé,
- une nouvelle application explosée est déplosée,
- un `WEB-INF/web.xml` a changé,
- un Context Descriptor a changé ou a été ajouté.

## Le JBoss Web Manager

[https://docs.jboss.org/jbossweb/3.0.x/manager-howto.html](https://docs.jboss.org/jbossweb/3.0.x/manager-howto.html)

## Le Client Deployer Package

Cet outil en plus de déployer peut compiler, vérifier et packager une application (bien sûr, JBoss doit être lancé pour que cela fonctionne).

TCD utilise en entrée une application explosée. Dans ce cas, le descripteur de contexte peut être présent à `/META-INF/context.xml`.

Le TCD repose en fait sur `Ant` pour son fonctionnement. Quelques *targets* ant sont fournies : `compile`, `deploy`, `undeploy`, `start`, `reload`, `stop`.

**Attention** : un utilisateur doit être configuré pour que tout ceci fonctionne. (voir la fin de [la doc](https://docs.jboss.org/jbossweb/3.0.x/deployer-howto.html)).

## Déploiement en mode développement depuis un IDE

Eclipse -> JBoss Tools

## Autre possibilité plus moderne

- déploiement statique dans un container Docker
- déploiement des serveur en utilisant Docker ou un orchestrateur.

## Qu'est-ce que le déploiement ?

Passer du dev à la production

Automatisation : compilation, packaging, tests, déploiement.

En gros, du code écrit par le(s) développeur(s) au code machine s'exécutant sur les serveurs de production répondant aux requêtes des clients.

Historiquement les métiers de développeur et d'exploitant ont été très cloisonnés. Le dev n'aime pas l'ops et inversément. Ils ne se comprennent pas.

Mouvement DevOps pour combler les manques entre les différents domaines et favoriser une intéraction fluide.

En fait et on le constatera dans les exercices, ces deux domaines ne sont pas imperméables : le code a un impact sur l'infrastructure possible pour le déploiement, et l'infrastructure donne des contraintes sur le code. Il va donc de soi que si les deux parties ne s'entendent ni ne se comprennent, on n'aura jamais quelque chose qui fonctionne correctement.

Afin de réduire le laps de temps entre l'écriture du code et sa mise à disposition à l'utilisateur, on va chercher à automatiser les processus impliqués, et ce de bout en bout.

## Quels sont les enjeux ?

Up-time,

Bandwidth

Performance

Scalability

## Création d'une application vraiment très simple

Avec Eclipse, créer une application *Dynamic Web Application* avec un seul JSP simple qui affiche le répertoire de Tomcat.

`index.jsp` :

		Bonjour !<br/>
		Le répertoire de déploiement est : 
		<%= System.getProperty("catalina.base") %>

C'est une application vraiment simple (pas d'état car pas de session).

Cette application affiche la propriété `catalina.base` qui reflète le répertoire d'installation de Tomcat.

Créer le fichier `.war` et le déployer dans le serveur Tomcat.

## Déployons sur un serveur

Un Tomcat simple.

Quels sont les problèmes ?

- Crash serveur = arrêt du service
- Montée de version = arrêt du service
- Montée en charge (difficulté pour gérer cela, pas de scaling automatique. Bon OK, disons que l'on connait à l'avance le nombre d'utilisateurs - il faut donc dimensionner la machine de production à l'*avance*).

## Comment faire face au problème de crash serveur ?

Un crash serveur, c'est un service inaccessible pour le client, et c'est donc en général une perte d'argent pour l'entreprise.

Simple, nous allons utiliser plusieurs serveurs (de préférences à différents points géographiques pour mitiger les risques de catastorphes naturelles).

Un serveur frontal va router les appels vers nos différents serveurs d'application. C'est le Load Balancer, il répartit les requêtes entrantes sur les serveurs d'application.

Nous allons installer un deuxième serveur Tomcat et NGINX configuré en Load balancer.

## Installer la seconde instance de Tomcat

- Duplicate the Tomcat installation directory
- Edit `server.xml` in the second one, change the port numbers.

- HTTP : 8081
- Redirection : 8444
- AJP : 8010
- Shutdown port : 8006

Editer `catalina.sh` du serveur 1. Positionner la variable CATALINA_HOME.

Faire de même pour le serveur 2 en adaptant la variable.

Déployer l'application précédente sur les **deux** serveurs Tomcat.

Dans deux terminaux différents, lancer chacun des Tomcat.

Vérifier dans un navigateur que les deux Tomcat sont lancés sur les ports 8080 et 8081 et que l'application est bien déployée sur les deux serveurs.

## Install NGINX

Utiliser apt

Configurer NGINX en Load Balancer

		http {
		    upstream application {
		        server localhost:8080;
		        server localhost:8081;
		    }

		    server {
		        listen 80;

		        location / {
		            proxy_pass http://application;
		        }
		    }
		}

Lancer le NGINX et vérifier que celui ce fonctionne et redirige vers les tomcats.

Recharger plusieurs fois la page pour vérifier que le load balancing se fait bien alternativement entre les deux serveurs.

Tuer un serveur et vérifier que l'application fonctionne toujours.

*Nginx détecte l'erreur sur le serveur arrêté et poursuit sur le serveur qui fonctionne.*

## Quels ont été les freins à l'automatisation ?

- Dépendance à Eclipse qui ne permet pas de construire les projets en ligne de commande => nous allons utiliser `maven`.

- Copie du fichier `.war` à la main, difficilement automatisable.

- Et en plus, les sources ne sont pas versionnées !

## Une application à état (simple)

Il est rare que la communication entre le client (navigateur) et le serveur n'ait pas d'état (au moins l'utilisateur connecté par exemple, souvent le panier pour un site de commerce électronique).

Nous allons donc introduire un état dans l'application : la session utilisateur et un cookie.

Mais avant, utilisons `git` et `maven`.

On va chercher le projet sur github :

		git clone https://github.com/ltearno/deploiement.git

Puis on le construit :

		mvn clean install

Le fichier `.war` résultat du build est disponible dans le répertoire `target/`.

## On déploie sur un tomcat

## On rafraichi et on voit que le LB envoie alternativement sur les deux versions

=> On verra cela plus tard, comment orchestrer les montées de version.

## Déployer sur les deux Tomcats

OK, l'application est maintenant à jour sur les deux Tomcat, donc utiliser le LB renvoie vers la même version.

Nouveau problème : la session est stockée localement par serveur Tomcat donc on a une fois sur deux la mauvaise session. Une fois sur deux Tomcat ne trouve pas la session puisqu'il s'agit de celle de l'autre Tomcat !!!

En fait Java EE se base sur le cookie `JSESSIONID` pour retrouver la session.

## Trois solutions

- Faire du sticky session. Nginx peut être configuré pour envoyer les clients sur le même serveur. On n'a plus le problème mais... On perd la session si le serveur crashe !!!

- Stocker la session dans une base de donnée pour les deux serveurs (TODO ESSAYER ET PROUVER CELA !)

- Utiliser JWT pour envoyer nos informations de "session" à partir du client. L'information est chifrée dans un cookie qui est transmit par le navigateur et qui reste le même quoique soit le client.

### Sticky load balancer

La première fois qu'un client se connecte, Nginx calcule un hash basé sur l'adresse IP du client et route ses requêtes toujours vers le même serveur.

Rajouter `ip_hash;` dans la section `upstream` de la configuration de Nginx.

Relancer Nginx.

Constater que maintenant la session est stable.

Mais si on arrête le serveur choisi par Nginx, que se passe-t-il ?

On perd la session ! Donc l'utilisateur connecté, son panier etc...

Retirer `ip_hash;` de la configuration de Nginx.

Relancer le serveur Tomcat précédemment arrêté.

AVANTAGE : on ne peut pas faire plus simple ! Et l'application survit bien au crash d'un de ses serveurs.

INCONVENIENTS : quand un des serveurs crashe on perd les sessions de tous les utilisateurs qui y étaient connectés.

### Stockage des sessions dans une base de données

On va utiliser MySQL, mais rien n'empêche d'utiliser Hazelcast ou Redis ou autre...

Installer MariaDB :

		apt install mariadb-server

Ne pas donner de mot de passe.

Ensuite :

		mysql -u root
		
		create database tomcat_sessions;
		
		use tomcat_sessions;
		
		create table tomcat_sessions (
		  session_id     varchar(100) not null primary key,
		  valid_session  char(1) not null,
		  max_inactive   int not null,
		  last_access    bigint not null,
		  app_name       varchar(255),
		  session_data   mediumblob,
		  KEY kapp_name(app_name)
		);

Utiliser cette [url](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22mysql%22%20AND%20a%3A%22mysql-connector-java%22) pour télécharger le connecteur JDBC pour MySql. Prendre la dernière `5.1.x`


### Utilisation de JWT

## Montées de version

## Problèmes avec plusieurs serveurs dupliqués

Les tâches de montée de version sont compliquées si *n* est trop grand.

## Plusieurs scénarios

1. OVERVIEW (2h, par exemple)
* Le déploiement d'application en général : avant, aujourd'hui et demain
** AVANT : souvent des mainframe, procédures de déploiement à rallonge, pas de flexibilité, très lent [cf. Lean Software Dev : un commit dans le master du projet peut mettre 2 ans ou plus à atteindre un client]. DE LA MERDE, donc.
** aujourd'hui : les entreprises qui réussissent (Netflix, Google, Amazon, Facebook...) déploient de plusieurs centains à plusieurs dizaines de milliers de fois par jour (là, je peux te trouver des liens et des quotes en fonction de ce que tu choisiras au final de traiter, dis-moi)
   déployer du code pissé 2 ans avant, c'est juste pas possible : le client ne voit rien, n'est pas content, et a toutes les chances de ne pas aimer ce qu'il veut si on ne l'intègre pas au processus très en amont
*** PIPELINE / Continuous Delivery : il faut donc aller plus vite (cf. plus haut sur les nombreux déploiements) et mieux : tout code doit pouvoir partir en prod AU PLUS VITE afin d'avoir du feedback client (Lean software dev, mapping avec le Lean Manufacturing => du code dans le repo pas en prod, c'est du STOCK. Et dans le manufacturing, qu'est-ce qu'on essaie de faire avec les stocks (une question à poser aux étudiants, à mon avis, même si ce n'est pas de l'info) ?

2. PRATIQUE  : BASES : 4h
[[ Idée : leur faire entrevoir les différentes étapes du build/pipeline du projet, avant d'envisager une automatisation de l'ensemble ]]

Fournir un war simple : Java EE 6 ou plutôt 7 : les sources + un .war tout prêt. 
Demander aux étudiants de le déployer dans un Tomcat (écrire un doc avec les différentes steps, genre http://batmat.github.io/presentations/git-next-level/labs/lab-correction-1-git-directory.html). Genre :
* télécharger Wildfly
* unzip etc.
* mettre le war dans ...
* lancer
* ouvrir http://localhost:8080
* expliquer
* changer le port (pour les forcer à bricoler la conf)

* Refaire avec Tomcat ou TomEE

* Itération de plus : 
* modifier une Servlet
* recompiler (install Maven, etc.)
* redéployer

poser des questions dans le doc de TP pour guider et faire réfléchir


THEORIE : 3h
Parler du config management des serveurs, l'immutabilité, les stratégies de déploiement (A/B testing, Blue Green Deployment, Canary Testing, ...)
Architectures Stateless/Stateful, l'intérêt (pas de session, plus simple, etc. par contre notion de cache à envisager tout de même)
HA : quoi c'est, LB, Failover...

Attention à ne pas utiliser le disque (i.e. si l'appel part sur un autre noeud, etc.)

EJB3 @Stateless attention aux attributs (genre stocker le nom du user en attribut : grosse bêtise...)

Parler aussi de l'évolution d'aujourd'hui : 
AVANT : on générait la page sur le serveur, etc. (Struts & co)
AUJOURD'HUI, avec Angular, GWT, etc. on va plutôt exploiter JS & co pour faire l'affichage côté client, et ne demander que la charge utile au serveur (API Rest,...)

PRATIQUE : HA : 4h

* Reprendre le war initial,
* deployer sur deux instances de Tomcat ou Wildfly
* configurer un nginx en front
* montrer que le kill violent d'un des noeuds passe inaperçu depuis un client

AUTRE PRATIQUE : Faire du blue green : déploiement continu avec les nouvelles versions. Intérêts du Stateless et déportation des états dans des composants répartissables : *memcached*, *redis*, *couchdb*, *mysql*...

CONCLUSION : 2h

Récap, tu reprends les trucs appris, etc.

Et tu finis en ouvrant sur la chance folle qu'ils ont d'être dans un domaine qui embauche au taquet, un petit coup sur le syndrôme du petit chef : vouloir être développeur UN PEU, AVANT de devenir chef. Qu'ils seront infiniment plus bankable s'ils cultivent leur compétence, et qu'ils ne s'ennuieront jamais. Qu'il faut continuer à apprendre, que ça fait partie de notre métier, pas avoir peur de la nouveauté, de la ligne de commande, etc.
Et s'ils cutivent ça, ils n'auront jamais aucun pb d'emploi (montrer des stats publiques sur les trends de boulot en fonction des branches, vs. le dev), et en plus ils s'éclateront au taf.
Difficile à formuler, ptete, mais éventuellement un ptit message pour encourager les filles à continuer. Que l'info n'est pas un métier réservé aux hommes, et qu'on a besoin de diversité au sens large pour que le monde soit meilleur :-).

### See you !

Slides : [lteconsulting.fr/annotation-processing](http://www.lteconsulting.fr/annotation-processing)

Demo project : [github.com/ltearno/gwtcon-jsr269](https://github.com/ltearno/gwtcon-jsr269)

Twitter : `@ltearno`

LTE Consulting : [lteconsulting.fr](http://www.lteconsulting.fr)

LinkedIn : [fr.linkedin.com/in/lteconsulting](https://fr.linkedin.com/in/lteconsulting)