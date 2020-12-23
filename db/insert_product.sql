use training;

load data  local infile "./test_data.csv"
into table product
fields terminated by ',' enclosed by'"'
lines terminated by '\r\n'
ignore 1 lines;

load data  local infile "./category.csv"
into table category
fields terminated by ',' enclosed by'"'
lines terminated by '\r\n'
ignore 1 lines;

insert into members(email, password, address, lastUpdatedBy, status)
values("test@example.com", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e", "hyogo", "none", "approval");

insert into members(email, password, address, lastUpdatedBy, status)
values("test2@example.com", "$2a$10$EQyVZTFajqzPEHVtmFXW2O7tq.czJbKO/Jf1EMYWziD26CaGzthTi", "kyoto", "none", "unapproved");

insert into admins(name, password)
values("admin", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e");
