drop database if exists training;

create database training;

use training;

CREATE TABLE admins (
id INT AUTO_INCREMENT,
name VARCHAR(128),
password VARCHAR(256),
PRIMARY KEY (id),
UNIQUE(name)
 );

CREATE TABLE members (
id INT AUTO_INCREMENT,
email VARCHAR(128),
password VARCHAR(256),
address VARCHAR(256),
PRIMARY KEY (id),
UNIQUE(email)
);

CREATE TABLE category(
id INT AUTO_INCREMENT,
name VARCHAR(16),
PRIMARY KEY (id)
);

CREATE TABLE product(
id INT AUTO_INCREMENT,
category_id INT,
name VARCHAR(128),
price INT,
image_path VARCHAR(20),
description TEXT,
PRIMARY KEY (id)
);

CREATE TABLE order_items (
  id INT(11) NOT NULL AUTO_INCREMENT,
  order_id INT(11) DEFAULT NULL,
  name VARCHAR(128) DEFAULT NULL,
  price INT(11) DEFAULT NULL,
  image_path VARCHAR(20) DEFAULT NULL,
  description TEXT,
  quantity INT(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE orders (
  id INT(11) NOT NULL AUTO_INCREMENT,
  phone VARCHAR(12) DEFAULT NULL,
  name VARCHAR(12) DEFAULT NULL,
  address TEXT,
  email TEXT,
  price INT(12),
  date VARCHAR(48) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
