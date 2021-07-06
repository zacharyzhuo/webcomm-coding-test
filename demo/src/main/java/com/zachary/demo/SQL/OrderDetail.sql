create table order_detail(
	id int(50) not null primary key AUTO_INCREMENT,
	order_id int(50) not null,
	product_id int(50) not null,
	amount int(50) not null,
    FOREIGN KEY(order_id) REFERENCES my_order(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
);