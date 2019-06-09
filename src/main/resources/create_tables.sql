-- create database springweb;
use springweb;

create table article (
	articleNo int primary key auto_increment,
    title varchar(40) not null,
    writer varchar(30) not null,
    content TEXT not null,
    regDate timestamp not null,
    viewCnt int not null
)default char set = utf8;