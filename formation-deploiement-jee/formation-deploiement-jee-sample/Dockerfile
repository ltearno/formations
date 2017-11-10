FROM tomcat:8.0.35-jre8

# copie du war
COPY mysql-connector-java-5.1.39.jar /usr/local/tomcat/lib/
COPY mysql-connector-java-5.1.39.jar /usr/local/tomcat/endorsed/
COPY target/deploiement-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
