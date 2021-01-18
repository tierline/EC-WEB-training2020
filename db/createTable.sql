drop database if exists training;

create database training;

use training;

-- TOREVIEW : sql を書かずに mybatis で定義できないか --
-- TABLE 名は大文字に。 mybatis-config から設定できる --
-- 会社方針：テーブル名は単数形 --

CREATE TABLE admins (
  id INT AUTO_INCREMENT,
  name VARCHAR(128),
  password VARCHAR(256),
  PRIMARY KEY (id),
  UNIQUE(name)
);

CREATE TABLE members (
  id INT(11) NOT NULL AUTO_INCREMENT,
  password VARCHAR(256),
  email VARCHAR(128),
  phone_number VARCHAR(16),

  last_name VARCHAR(32),
  first_name VARCHAR(32),

  postcode VARCHAR(16),
  prefecture VARCHAR(16),
  city VARCHAR(256),
  block	 VARCHAR(256),

  -- last_updated_by -> last_update_admin 明示的に --
  last_updated_by VARCHAR(32), -- default: "none", changed: "変更した管理者の名前" --
  status VARCHAR(32), -- 未承認:unapproved, 承認:approval --
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
  order_id INT(11),
  name VARCHAR(128),
  price INT(11),
  image_path VARCHAR(20),
  description TEXT,
  quantity INT(11),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE orders (
  id INT(11) NOT NULL AUTO_INCREMENT,
  member_id INT(11) NOT NULL,
  email VARCHAR(128),
  phone_number VARCHAR(16),
  name VARCHAR(32),
  address VARCHAR(256),
  price INT(12),
  date DATE,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
