create database hibernate;
use hibernate;

create table Employee(
	id int(11) unsigned primary key not null auto_increment, 
    nome varchar(20) default null,
    role varchar(20) default null,
    insert_time datetime default null
)ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;