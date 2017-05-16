#!/bin/bash

asciidoctor -T asciidoctor-reveal.js/templates/slim index.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim standard.ad
asciidoctor tp-appengine.ad