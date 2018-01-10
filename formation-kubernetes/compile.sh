#!/bin/bash

asciidoctor -T asciidoctor-reveal.js/templates/slim index.ad

cd tp0
asciidoctor tp-0.ad
cd ..

cd tp1
asciidoctor tp-1.ad
cd ..

cd tp2
asciidoctor tp-2.ad
cd ..
