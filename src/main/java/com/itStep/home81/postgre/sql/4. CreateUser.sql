CREATE TABLE t_user (
	customer_id SERIAL PRIMARY KEY,
	first_name varchar (30) NOT NULL,
	last_name varchar (30) NOT NULL,
	user_name varchar (30) NOT NULL UNIQUE,
	password varchar (50) NOT NULL,
	addres varchar (80) NOT NULL,
	birthdate date NOT NULL,
	user_group_id int,
	FOREIGN KEY (user_group_id) REFERENCES t_user_group ("user_group_id")
);