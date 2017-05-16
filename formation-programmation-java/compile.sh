#!/bin/bash

asciidoctor tp-struts.ad
asciidoctor tp-web-services.ad
asciidoctor exercices-javaee.ad
asciidoctor cours-java.ad
asciidoctor exercices-java.ad
asciidoctor tp-reseau.ad
asciidoctor index.ad
asciidoctor tp-morpion.ad

asciidoctor -T asciidoctor-reveal.js/templates/slim struts.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim cours-javaee.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim maven.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim uml-profils.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim pattern-commande.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim fichiers.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim threads.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim reseau.ad
asciidoctor -T asciidoctor-reveal.js/templates/slim web-services.ad