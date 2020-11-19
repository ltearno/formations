#!/bin/bash

docker build . -t tp-kubernetes:1.1

kubectl apply -f web-server.yaml