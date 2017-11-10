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