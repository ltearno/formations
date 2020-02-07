#!/bin/bash

#gem install asciidoctor tilt haml thread_safe concurrent-ruby
#gem install slim --version 2.1.0

asciidoctor -T asciidoctor-reveal.js/templates/slim index.ad -o index.html

cd tp0
asciidoctor tp-0.ad
cd ..

cd tp1
asciidoctor tp-1.ad
cd ..

cd tp2
asciidoctor tp-2.ad
cd ..
