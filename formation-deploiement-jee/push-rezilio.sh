#!/bin/bash

rsync index.html rezil.io:/home/arnaud/formation-javaee-site/
rsync tp.html rezil.io:/home/arnaud/formation-javaee-site/

rsync formation-deploiement-jee-sample/squelette-tp.zip rezil.io:/home/arnaud/formation-javaee-site/squelette-tp.zip

rsync -r images reveal.js rezil.io:/home/arnaud/formation-javaee-site/