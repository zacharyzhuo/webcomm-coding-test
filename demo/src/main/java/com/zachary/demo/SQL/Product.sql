create table product(
	id int(50) not null primary key AUTO_INCREMENT,
	name varchar(50) not null,
	price int(50) not null,
	inventory int(50) not null
);

insert into product
values (0, '蘋果', 10, 10),
(0, '香蕉', 12, 10),
(0, '西瓜', 20, 10);