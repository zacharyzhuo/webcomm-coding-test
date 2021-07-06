create table my_order(
	id int(50) not null primary key AUTO_INCREMENT,
	username varchar(50) not null,
	create_date datetime not null DEFAULT CURRENT_TIMESTAMP,
	state boolean not null,
	total int(50) not null
);