#!/bin/bash

for i in *.ad
do
    echo "compiling $i"
    if [[ $i == "slides-"* ]]; then
        asciidoctor -T asciidoctor-reveal.js/templates/slim $i
    else
        asciidoctor $i
    fi
done

for i in "angular" "deploiement-jee" "git" "google-app-engine" "html-css-javascript" "programmation-java"
do
    echo "doing $i"
    cd "formation-$i"
    ./compile.sh
    cd ..
done