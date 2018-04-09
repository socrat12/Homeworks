CREATE TABLE t_user (
	id SERIAL PRIMARY KEY,
	first_name varchar (30) NOT NULL,
	last_name varchar (30) NOT NULL,
	nickname varchar (30) NOT NULL,
	password varchar (50) NOT NULL,
	addres varchar (50) NOT NULL,
	birthdate date NOT NULL,
	addres varchar (80) NOT NULL
);