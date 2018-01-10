#!/bin/bash

set -e

VERSION=$1

echo ""
echo "=============================================="
echo "          DEPLOYING VERSION ${VERSION}"
echo "=============================================="
echo ""

for file in $(find ./ -name '*.yaml')
do
    echo ""
    echo "updating ${file}"
    echo ""
    cat $file | \
        sed "s|VERSION|${VERSION}|g" | \
        kubectl apply -f -
done

echo "deployment done version ${VERSION}"