CREATE TABLE t_book (
	book_id SERIAL PRIMARY KEY,
	price int NOT NULL,
	date_prod int NOT NULL,
	category varchar (30) NOT NULL,
	int_stock int NOT NULL,
	autor_id int REFERENCES t_autor ("autor_id")
);