create database business ;
use business;


CREATE TABLE `PRODUCTS`(
                           id INT NOT NULL AUTO_INCREMENT primary KEY ,
                           name varchar(255) not null ,
                           color  varchar(255) not null ,
                           buying_price double not null ,
                           selling_price double not null ,
                           size  varchar(255) null ,
                           description  varchar(255) null
);

CREATE TABLE `ORDERS`(
                         id INT NOT NULL AUTO_INCREMENT primary KEY ,
                         items_count double not null ,
                         total_price double not null ,
                         total_profit double not null ,
                         customer_phone varchar(255) default null ,
                         creation_time datetime not null ,
                         description varchar(255) default null
);