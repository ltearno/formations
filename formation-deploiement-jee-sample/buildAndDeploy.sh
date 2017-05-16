#!/bin/bash

# application
mvn clean install
sudo docker build -t ltearno/application .

# base de donnees sessions
sudo docker build -t ltearno/mariadb -f session-database.dockerfile .

# load balancer Nginx
sudo docker build -t ltearno/lb -f nginx-loadbalancer.dockerfile .

# arret des containers
echo "Arret des containers"
sudo docker rm -f load_balancer
for i in {0..3}
do
	sudo docker rm -f application0$i
done
sudo docker rm -f database

# lancement base de données
echo "Lancement base de données"
sudo docker run -d --name database ltearno/mariadb

# lancement serveurs d'application
for i in {0..3}
do
	echo "Lancement server d'application $i"
	sudo docker run -d --name application0$i --link database:database ltearno/application
done

# lancement du load balancer
cmd='sudo docker run -d --name load_balancer '
for i in {0..3}
do
	cmd="$cmd --link application0$i:application0$i"
done
cmd="$cmd -p 80:80 ltearno/lb"
echo "Lancement du load balancer"
eval $cmd

echo "Liste de containers lancés"
sudo docker ps -a
