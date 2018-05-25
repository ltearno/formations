#!/bin/bash

asciidoctor -T asciidoctor-reveal.js/templates/slim index.ad
asciidoctor tp.ad
