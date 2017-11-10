#!/bin/bash

for i in *.ad
do
    echo "compiling $i"
    asciidoctor $i
done