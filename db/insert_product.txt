use training;

load data  local infile "./product.csv"
into table product
fields terminated by ',' enclosed by'"'
lines terminated by '\r\n'
ignore 1 lines;