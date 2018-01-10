#!/bin/bash

set -e

VERSION=$1

echo ""
echo "=============================================="
echo "          BUILD AND DEPLOY ${VERSION}"
echo "=============================================="
echo ""

echo "Construction et deploiement de l'application en version ${VERSION}"

./build.sh $VERSION

./deploy.sh $VERSION

echo "everything done !"