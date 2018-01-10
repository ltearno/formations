#!/bin/bash

set -e

VERSION=$1

echo ""
echo "=============================================="
echo "          BUILDING MICRO SERVICES"
echo "=============================================="
echo ""

echo "Building and pushing store"
cd store
./build.sh $VERSION
cd ..

echo "Building and pushing back"
cd back
./build.sh $VERSION
cd ..

echo "build done"