drop database if exists training;

create database training;

use training;

create table ADMINS (
id bigint auto_increment,
name varchar(128),
password varchar(256),
PRIMARY KEY (id),
UNIQUE(name)
 );

create table MEMBERS (
id bigint auto_increment,
email varchar(128),
password varchar(256),
address varchar(256),
PRIMARY KEY (id),
UNIQUE(email)
);

create table CATEGORY(
id int auto_increment primary key,
name varchar(16));

create table product(
id int auto_increment primary key,
category_id int,
name varchar(128),
price int,
image_path varchar(20),
description text
);


CREATE TABLE `ORDER_ITEMS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image_path` varchar(20) DEFAULT NULL,
  `description` text,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- training.orders definition
CREATE TABLE `ORDERS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(12) DEFAULT NULL,
  `name` varchar(12) DEFAULT NULL,
  `address` text,
  `email` text,
  `price` int(12),
  `date` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
