use training;

-- load data  local infile "./test_data.csv"
-- into table PRODUCT
-- fields terminated by ',' enclosed by'"'
-- lines terminated by '\r\n'
-- ignore 1 lines;


-- load data  local infile "./category.csv"
-- into table CATEGORY
-- fields terminated by ',' enclosed by'"'
-- lines terminated by '\r\n'
-- ignore 1 lines;

insert into MEMBERS(email, password, address)
values("test@example.com", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e", "hyogo");

insert into MEMBERS(email, password, address)
values("test2@example.com", "$2a$10$EQyVZTFajqzPEHVtmFXW2O7tq.czJbKO/Jf1EMYWziD26CaGzthTi", "kyoto");

insert into ADMINS(name, password)
values("admin", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e");
