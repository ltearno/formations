#!/bin/bash

BASE=/var/www/lteconsulting.mano/formations

scp index.html arnaud@lteconsulting.fr:$BASE/

scp formation-angular/index.html \
    formation-angular/travaux-pratiques.html \
    arnaud@lteconsulting.fr:$BASE/angular/

scp formation-deploiement-jee/index.html \
    formation-deploiement-jee/tp.html \
    arnaud@lteconsulting.fr:$BASE/deploiement-jee/

scp formation-git/index.html \
    arnaud@lteconsulting.fr:$BASE/git/

scp formation-google-app-engine/index.html \
    formation-google-app-engine/tp-appengine.html \
    arnaud@lteconsulting.fr:$BASE/google-app-engine/

scp formation-html-css-javascript/slides/index.html \
    arnaud@lteconsulting.fr:$BASE/html-css-javascript/

scp formation-programmation-java/cours/*.html \
    arnaud@lteconsulting.fr:$BASE/java/
scp formation-programmation-java/cours/exercices/*.html \
    arnaud@lteconsulting.fr:$BASE/java/exercices/