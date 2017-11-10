FROM mariadb:5.5
ENV MYSQL_ROOT_PASSWORD=root
ADD tomcat_sessions.sql /docker-entrypoint-initdb.d/
# ADD init-tomcat-sessions.sh /docker-entrypoint-initdb.d/
# RUN chmod -R 755 /docker-entrypoint-initdb.d/init-tomcat-sessions.sh
# RUN /init-tomcat-sessions.sh
