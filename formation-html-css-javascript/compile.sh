#!/bin/bash

asciidoctor javascript-jquery.ad

cd slides
./compile.sh
cd ..