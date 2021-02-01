use training;

load data  local infile "./test_data.csv"
into table PRODUCT
fields terminated by ',' enclosed by'"'
lines terminated by '\r\n'
ignore 1 lines;

INSERT INTO MEMBER(email, last_name, first_name, password, postcode, prefecture, city, block, phone_number, last_update, status)
VALUES("test@example.com", "坂本", "龍馬", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e", "5450021", "兵庫県", "神戸市東灘区", "56番地", "0785555525", "none", "APPROVAL");

INSERT INTO ADMIN(name, password)
VALUES("admin", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e");
