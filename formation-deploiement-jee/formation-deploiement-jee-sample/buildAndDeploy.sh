#!/bin/bash

# application
mvn clean install
docker build -t ltearno/application .

# base de donnees sessions
docker build -t ltearno/mariadb -f session-database.dockerfile .

# load balancer Nginx
docker build -t ltearno/lb -f nginx-loadbalancer.dockerfile .

# arret des containers
echo "Arret des containers"
docker rm -f load_balancer
for i in {0..3}
do
	docker rm -f application0$i
done
docker rm -f database

# lancement base de données
echo "Lancement base de données"
docker run -d --name database ltearno/mariadb

# lancement serveurs d'application
for i in {0..3}
do
	echo "Lancement server d'application $i"
	docker run -d --name application0$i --link database:database ltearno/application
done

# lancement du load balancer
cmd='docker run -d --name load_balancer '
for i in {0..3}
do
	cmd="$cmd --link application0$i:application0$i"
done
cmd="$cmd -p 80:80 ltearno/lb"
echo "Lancement du load balancer"
eval $cmd

echo "Liste de containers lancés"
docker ps -a
