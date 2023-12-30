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