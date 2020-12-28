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

INSERT INTO members(email, last_name, first_name, password, postcode, prefecture, city, block, phone_number, last_updated_by, status)
VALUES("test@example.com", "坂本", "慎太郎", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e", "655-0053", "兵庫県", "神戸市東灘区", "56番地", "078-555-5525", "none", "approval");

-- INSERT INTO members(email, password, address, lastUpdatedBy, status)
-- VALUES("test@example.com", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e", "hyogo", "none", "approval");

-- INSERT INTO members(email, password, address, lastUpdatedBy, status)
-- VALUES("test2@example.com", "$2a$10$EQyVZTFajqzPEHVtmFXW2O7tq.czJbKO/Jf1EMYWziD26CaGzthTi", "kyoto", "none", "unapproved");

INSERT INTO admins(name, password)
VALUES("admin", "$2a$10$uhuqnvtjTayBhSjs7ezeB.2DG5GlIERAawzRoCROyTxWpzwKy7T.e");
