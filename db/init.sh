#!/bin/bash
cd db

set character_set_database = utf8;
set character_set_client = utf8;
set character_set_connection = utf8;

echo -------create table--------

mysql --defaults-extra-file=root.conf < createTable.sql


echo ------- finish--------

echo -------create table--------


mysql --defaults-extra-file=root.conf --enable-local-infile < ./insert_product.sql

echo ------- finish--------

cd ..

