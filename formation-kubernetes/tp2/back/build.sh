#!/bin/bash

set -e

VERSION=$1

echo ""
echo "=============================================="
echo "          BUILDING BACK ${VERSION}"
echo "=============================================="
echo ""

# construit l'image docker
docker build -t eu.gcr.io/blockchain-js/back:${VERSION} .

# envoi l'image docker sur le registry docker de GCP
gcloud docker -- push eu.gcr.io/blockchain-js/back:${VERSION}

# pour executer l'image en local:
# docker run -p 80:80 eu.gcr.io/blockchain-js/back:${VERSION}