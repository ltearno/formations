#!/bin/bash

curl http://localhost:8080/toto &
sleep 1
curl http://localhost:8080/toto &
sleep 1
curl http://localhost:8080/toto &
sleep 1
curl http://localhost:8080/toto &
sleep 1
curl http://localhost:8080/toto &
sleep 1

curl http://localhost:8080/stop