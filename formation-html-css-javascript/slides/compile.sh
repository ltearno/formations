#!/bin/bash

pandoc -s -t revealjs index.md -o index.html --css reveal.js/css/theme/beige.css --slide-level 3 --no-highlight --variable hlss=zenburn --template reveal-template.html