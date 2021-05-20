#!/bin/bash

# sudo gem install tilt slim concurrent-ruby

asciidoctor -T asciidoctor-reveal.js/templates/slim index.ad -o index.html
asciidoctor tp.ad -o tp.html