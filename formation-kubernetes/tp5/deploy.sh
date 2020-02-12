#!/bin/bash

cat tp5.yaml | \
    sed "s/CLE_PRIVEE/$(cat tls.key.pem | base64 -w 0)/g" | \
    sed "s/CERTIFICAT/$(cat tls.cert.pem | base64 -w 0)/g" | \
    kubectl apply -f -