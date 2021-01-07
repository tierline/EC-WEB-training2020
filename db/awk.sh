#!/bin/bash

cat productAll.csv |awk -f ',' '{printf"insert into product values(\x27%s\x27,\x27%s\x27,\x27%s\x27);",$2,$3,$4,$5,$6,$7,$8,$9,$10;print""}'

cat productAll.csv

cat productAll.csv | awk -F',' '{ printf "INSERT INTO tablename VALUES (\x27%s\x27,\x27%s\x27,\x27%s\x27,\x27%s\x27,\x27%s\x27,\x27%s\x27);",$1,$2,$3,$4,$5,$6;print ""}'




echo -------create table--------

mysql --defaults-extra-file=root.conf < insert_product.txt

echo ------- finish--------



